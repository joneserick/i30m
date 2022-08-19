package br.com.stefick.i30m.features.images.models

import br.com.stefick.i30m.features.breed.models.Breed
import com.google.gson.annotations.SerializedName
import java.util.Locale.Category

data class Cat(
    val id: String,
    val url: String?,
    val width: Short,
    val height: Short,
    @SerializedName("mime_type")
    val mimeType: String,
    val breeds: ArrayList<Breed>?,
    val categories: ArrayList<Category>?,
    @SerializedName("breed_ids")
    val breedIds: String
)