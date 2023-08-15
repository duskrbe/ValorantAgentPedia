package edu.arbyfebrian.valorantagentpedia

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.arbyfebrian.valorantagentpedia.models.Agent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AgentFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var agentsAdapter: AgentsAdapter

    // Variable to store the current scroll position
    private var currentScrollPosition: Int = 0


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_agent, container, false)
        recyclerView = rootView.findViewById(R.id.recyclerViewAgents)

        // Use GridLayoutManager to display items in 2 columns
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        // Initialize the adapter with an empty mutable list
        //this buat fragm,ent require
        agentsAdapter = AgentsAdapter(requireContext(),mutableListOf())
        recyclerView.adapter = agentsAdapter

        // Call the API and fetch the agents
        fetchAgents()

        return rootView
    }

    private fun fetchAgents() {
        val retrofitInstance = RetrofitInstance()
        val api = retrofitInstance.api

        GlobalScope.launch(Dispatchers.Main) {
            try {
                // Call the suspend function to fetch agents
                val response = api.getAgents()
                if (response.isSuccessful) {
                    val agentResponse = response.body()
                    val agents: List<Agent>? = agentResponse?.data

                    agents?.let {
                        Log.d("AgentFragment", "Fetched agents count: ${it.size}")
                        Log.d("AgentFragment", "API Response: ${response.body()}")
                        agentsAdapter.updateAgentsList(it)
                    }

                    // Restore the scroll position if it was saved
                    recyclerView.scrollToPosition(currentScrollPosition)

                } else {
                    // Handle the API call failure
                }
            } catch (e: Exception) {
                // Handle any exceptions that occur during the API call
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("AgentFragment", "Current Scroll Position: $currentScrollPosition")

        // Restore the scroll position if it was saved
        recyclerView.scrollToPosition(currentScrollPosition)

    }

    override fun onPause() {
        super.onPause()

        // Save the current scroll position
        currentScrollPosition = (recyclerView.layoutManager as? LinearLayoutManager)?.findFirstCompletelyVisibleItemPosition() ?: 0

        // Debug: Print the current scroll position
        Log.d("AgentFragment", "Current Scroll Position: $currentScrollPosition")
    }


    override fun onResume() {
        super.onResume()

        // Restore the scroll position when the fragment is resumed
        recyclerView.scrollToPosition(currentScrollPosition)
    }

}