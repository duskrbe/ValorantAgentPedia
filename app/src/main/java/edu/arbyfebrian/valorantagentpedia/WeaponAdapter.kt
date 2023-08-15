package edu.arbyfebrian.valorantagentpedia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.arbyfebrian.valorantagentpedia.models.Weapon

class WeaponAdapter(private val context: Context, private val weaponList: List<Weapon>) :
    RecyclerView.Adapter<WeaponAdapter.WeaponViewHolder>() {

    class WeaponViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewWeaponIcon: ImageView = itemView.findViewById(R.id.imageViewWeaponIcon)
        val textViewWeaponName: TextView = itemView.findViewById(R.id.textViewWeaponName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weapons, parent, false)
        return WeaponViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeaponViewHolder, position: Int) {
        val currentItem = weaponList[position]

        Glide.with(context)
            .load(currentItem.displayIcon)
            .into(holder.imageViewWeaponIcon)
        holder.textViewWeaponName.text = currentItem.displayName

    }

    override fun getItemCount() = weaponList.size
}