package edu.arbyfebrian.valorantagentpedia.models.responses

import edu.arbyfebrian.valorantagentpedia.models.Maps

data class MapResponse (
    val status: Int,
    val data: List<Maps>
)