package edu.arbyfebrian.valorantagentpedia

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.arbyfebrian.valorantagentpedia.models.Agent

class AgentsAdapter(private val context: Context, private val agentList: MutableList<Agent>) :
    RecyclerView.Adapter<AgentsAdapter.AgentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_agents, parent, false)
        return AgentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        val currentItem = agentList[position]

        holder.textViewName.text = currentItem.displayName
        holder.textViewRole.text = currentItem.role.displayName

        // Load the agent icon using Glide
        Glide.with(context)
            .load(currentItem.displayIcon)
            .into(holder.imageViewIcon)

        holder.itemView.setOnClickListener {
            // Launch the DetailAgentFragment with the selected agent
            val fragmentManager = (context as FragmentActivity).supportFragmentManager
            val detailFragment = DetailAgentFragment.newInstance(currentItem)
            fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, detailFragment)
                .addToBackStack(null)
                .commit()
        }

        Log.d("AgentFragment", "Agent name: ${currentItem.displayName}, Role: ${currentItem.role.displayName}")
    }


    override fun getItemCount() = agentList.size

    // Method to update the list of agents
    fun updateAgentsList(newAgents: List<Agent>) {
        Log.d("AgentFragment", "New Agents Count: ${newAgents.size}")

        // Clear the current list and add only playable agents to it
        agentList.clear()
        agentList.addAll(newAgents)
        //agentList.addAll(newAgents.filter { it.isPlayableCharacter })
        notifyDataSetChanged()
    }


    class AgentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewIcon: ImageView = itemView.findViewById(R.id.imageViewPoster)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewRole: TextView = itemView.findViewById(R.id.textViewRole)
    }
}