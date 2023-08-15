package edu.arbyfebrian.valorantagentpedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MapsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mapAdapter: MapsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_maps, container, false)
        recyclerView = rootView.findViewById(R.id.recyclerViewMaps)

        // Fetch maps using RetrofitInstance
        fetchMaps()

        return rootView
    }

    private fun fetchMaps() {
        val retrofitInstance = RetrofitInstance()

        // Launch a coroutine to call fetchMaps() suspend function
        lifecycleScope.launch {
            val mapList = retrofitInstance.fetchMaps()

            // Initialize the adapter with the list of maps
            mapAdapter = MapsAdapter(requireContext(), mapList)

            // Set the adapter to the RecyclerView
            recyclerView.adapter = mapAdapter

            // Set the layout manager
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }


}
