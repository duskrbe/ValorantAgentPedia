package edu.arbyfebrian.valorantagentpedia.models.responses

import edu.arbyfebrian.valorantagentpedia.models.Weapon

data class WeaponResponse(
    val status: Int,
    val data: List<Weapon>
)