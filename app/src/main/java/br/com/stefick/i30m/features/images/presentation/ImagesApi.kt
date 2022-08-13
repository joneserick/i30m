package br.com.stefick.i30m.features.images.presentation

import br.com.stefick.i30m.features.images.models.ImagesResponse
import retrofit2.http.GET

interface ImagesApi {

    @GET("images/search")
    suspend fun getCatImages(): ArrayList<ImagesResponse>

}