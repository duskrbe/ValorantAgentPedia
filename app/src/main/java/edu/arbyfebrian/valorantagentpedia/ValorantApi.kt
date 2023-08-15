package edu.arbyfebrian.valorantagentpedia

import edu.arbyfebrian.valorantagentpedia.models.responses.AgentResponse
import edu.arbyfebrian.valorantagentpedia.models.responses.MapResponse
import edu.arbyfebrian.valorantagentpedia.models.responses.WeaponResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ValorantApi {
    @GET("v1/agents")
    suspend fun getAgents(
        @Query("isPlayableCharacter") isPlayableCharacter: Boolean = true
    ): Response<AgentResponse>

    @GET("v1/weapons")
    suspend fun getWeapons(): Response<WeaponResponse>

    @GET("v1/maps")
    suspend fun getMaps(): Response<MapResponse>
}

