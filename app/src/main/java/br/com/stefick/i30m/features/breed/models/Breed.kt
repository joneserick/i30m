package br.com.stefick.i30m.features.breed.models

data class Breed(
    val id: String,
    val name: String
)

data class BreedDetails(
    val id: String,
    val name: String,
    val weight: String,
    val height: String,
    val life_span: String,
    val bred_for: String,
    val breed_group: String
)