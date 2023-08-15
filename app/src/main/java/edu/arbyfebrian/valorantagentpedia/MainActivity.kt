package edu.arbyfebrian.valorantagentpedia

import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the Toolbar as the support action bar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Hide the app title from the Toolbar
        supportActionBar?.setDisplayShowTitleEnabled(false)


        // Menghubungkan AgentFragment ke MainActivity
        val agentFragment = AgentFragment()
        supportFragmentManager.beginTransaction()//pindah fragment
            .replace(R.id.fragmentContainer, agentFragment)
            .commit()

        // Set the initial title
        val titleTextView: TextView = findViewById(R.id.textViewTitle)
        titleTextView.text = "Agents"//judul dihalaman


        // Handle item clicks on the BottomNavigationView
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_agents -> {
                    titleTextView.text = "Agents"
                    val agentFragment = AgentFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, agentFragment)
                        .commit()
                    // Replace the fragment with the desired fragment for the agents tab
                    // For example:
                    // val agentFragment = AgentFragment()
                    // supportFragmentManager.beginTransaction()
                    //    .replace(R.id.fragmentContainer, agentFragment)
                    //    .commit()
                    true
                }
                R.id.menu_weapons -> {
                    titleTextView.text = "Weapons"
                    val WeaponFragment = WeaponFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, WeaponFragment)
                        .commit()
                    // Handle other menu items here and update the title accordingly
                    // For example:
                    // titleTextView.text = "Other Tab"
                    true
                }
                R.id.menu_maps -> {
                    titleTextView.text = "Maps"
                    val MapsFragment = MapsFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, MapsFragment)
                        .commit()
                    // Handle other menu items here and update the title accordingly
                    // For example:
                    // titleTextView.text = "Other Tab"
                    true
                }
                else -> false
            }
        }
    }
}