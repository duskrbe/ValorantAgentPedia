package edu.arbyfebrian.valorantagentpedia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.arbyfebrian.valorantagentpedia.models.Maps

class MapsAdapter(private val context: Context, private val mapList: List<Maps>) :
    RecyclerView.Adapter<MapsAdapter.MapViewHolder>() {

    class MapViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewMapSplash: ImageView = itemView.findViewById(R.id.imageViewMapSplash)
        val textViewMapName: TextView = itemView.findViewById(R.id.textViewMapName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_maps, parent, false)
        return MapViewHolder(view)
    }

    override fun onBindViewHolder(holder: MapViewHolder, position: Int) {
        val currentItem = mapList[position]

        Glide.with(context)
            .load(currentItem.splash)
            .into(holder.imageViewMapSplash)

        holder.textViewMapName.text = currentItem.displayName

    }

    override fun getItemCount() = mapList.size
}