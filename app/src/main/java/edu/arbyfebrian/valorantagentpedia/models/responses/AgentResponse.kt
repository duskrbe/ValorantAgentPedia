package edu.arbyfebrian.valorantagentpedia.models.responses

import edu.arbyfebrian.valorantagentpedia.models.Agent

data class AgentResponse(
    val status: Int,
    val data: List<Agent>
)