package edu.arbyfebrian.valorantagentpedia

import edu.arbyfebrian.valorantagentpedia.models.Abilities
import edu.arbyfebrian.valorantagentpedia.models.Agent
import edu.arbyfebrian.valorantagentpedia.models.Maps
import edu.arbyfebrian.valorantagentpedia.models.Role
import edu.arbyfebrian.valorantagentpedia.models.Weapon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://valorant-api.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(ValorantApi::class.java)

    // Create a coroutine scope
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    // Define a suspend function to make the API call and return the list of agents
    suspend fun fetchAgents(): List<Agent> {
        try {
            val response = api.getAgents()

            if (response.isSuccessful) {
                val agentResponse = response.body()
                val agents: List<Agent>? = agentResponse?.data

                agents?.let {
                    // Extract the required data (displayName, role{displayName}, and displayIcon)
                    return it.map { agent ->
                        val roleDisplayName = agent.role.displayName
                        val roleDescription = agent.role.description
                        val roleDisplayIcon = agent.role.displayIcon
                        val displayIcon = agent.displayIcon
                        val fullPortrait = agent.fullPortrait
                        val background = agent.background


                        Agent(
                            displayName = agent.displayName,
                            description = agent.description,
                            role = Role(
                                displayName = roleDisplayName,
                                description = roleDescription,
                                displayIcon = roleDisplayIcon
                            ),
                            displayIcon = displayIcon,
                            fullPortrait = fullPortrait,
                            background = background,
                            abilities = listOf(
                                Abilities(
                                    slot = agent.abilities[0].slot,
                                    displayName = agent.abilities[0].displayName,
                                    description = agent.abilities[0].description,
                                    displayIcon = agent.abilities[0].displayIcon
                                ),
                                Abilities(
                                    slot = agent.abilities[1].slot,
                                    displayName = agent.abilities[1].displayName,
                                    description = agent.abilities[1].description,
                                    displayIcon = agent.abilities[1].displayIcon
                                ),
                                Abilities(
                                    slot = agent.abilities[2].slot,
                                    displayName = agent.abilities[2].displayName,
                                    description = agent.abilities[2].description,
                                    displayIcon = agent.abilities[2].displayIcon
                                ),
                                Abilities(
                                    slot = agent.abilities[3].slot,
                                    displayName = agent.abilities[3].displayName,
                                    description = agent.abilities[3].description,
                                    displayIcon = agent.abilities[3].displayIcon
                                )
                            )
                        )
                    }
                }
            } else {
                // Handle the API call failure
            }
        } catch (e: Exception) {
            // Handle any exceptions that occur during the API call
        }

        return emptyList()
    }


    // Member function to trigger the API call using a coroutine
    fun fetchAgentsAndProcessData() {
        // Launch a coroutine to call the fetchAgents() suspend function
        coroutineScope.launch {
            val agentList = fetchAgents()

            // Use the agentList as needed in your application
        }
    }

    suspend fun fetchWeapons(): List<Weapon> {
        try {
            val response = api.getWeapons()

            if (response.isSuccessful) {
                val weaponResponse = response.body()
                val weapons: List<Weapon>? = weaponResponse?.data

                weapons?.let {
                    return it // List<Weapon>
                }
            } else {
                // Handle the API call failure
            }
        } catch (e: Exception) {
            // Handle any exceptions that occur during the API call
        }

        return emptyList()
    }

    fun fetchWeaponsAndProcessData() {
        coroutineScope.launch {
            val weaponList = fetchWeapons()

            // Use the weaponList as needed in your application
        }
    }

    suspend fun fetchMaps(): List<Maps> {
        try {
            val response = api.getMaps()

            if (response.isSuccessful) {
                val mapResponse = response.body()
                val maps: List<Maps>? = mapResponse?.data

                maps?.let {
                    return it // List<Map>
                }
            } else {
                // Handle the API call failure
            }
        } catch (e: Exception) {
            // Handle any exceptions that occur during the API call
        }

        return emptyList()
    }

    fun fetchMapsAndProcessData() {
        coroutineScope.launch {
            val mapList = fetchMaps()

            // Use the weaponList as needed in your application
        }
    }

}
