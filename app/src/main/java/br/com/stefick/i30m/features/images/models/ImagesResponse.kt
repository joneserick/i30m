package br.com.stefick.i30m.features.images.models

import br.com.stefick.i30m.features.breed.models.Breed
import br.com.stefick.i30m.features.category.models.Category

data class ImagesResponse(
    val breeds: ArrayList<Breed>,
    val categories: ArrayList<Category>,
    val id: String,
    val url: String
)


