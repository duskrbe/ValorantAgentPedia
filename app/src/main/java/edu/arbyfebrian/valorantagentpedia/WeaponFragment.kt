package edu.arbyfebrian.valorantagentpedia
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class WeaponFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var weaponAdapter: WeaponAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_weapon, container, false)
        recyclerView = rootView.findViewById(R.id.recyclerViewWeapons)

        // Fetch weapons using RetrofitInstance
        fetchWeapons()

        return rootView
    }

    private fun fetchWeapons() {
        val retrofitInstance = RetrofitInstance()

        // Launch a coroutine to call fetchWeapons() suspend function
        lifecycleScope.launch {
            val weaponList = retrofitInstance.fetchWeapons()

            // Initialize the adapter with the list of weapons
            weaponAdapter = WeaponAdapter(requireContext(), weaponList)

            // Set the adapter to the RecyclerView
            recyclerView.adapter = weaponAdapter

            // Set the layout manager
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }
}
