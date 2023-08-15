package edu.arbyfebrian.valorantagentpedia.models

import java.io.Serializable
data class Agent(
    val displayName: String,
    val description: String,
    val role: Role,
    val displayIcon: String,
    val fullPortrait: String,
    val background: String,
    val abilities: List<Abilities>
): Serializable
