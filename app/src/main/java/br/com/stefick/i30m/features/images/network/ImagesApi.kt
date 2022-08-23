package br.com.stefick.i30m.features.images.network

import br.com.stefick.i30m.features.images.models.Cat
import br.com.stefick.i30m.features.images.models.ImagesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImagesApi {

    @GET("images/search")
    suspend fun getCatImages(@Query("limit") limit: Int, @Query("has_breeds") hasBreeds: Int): ArrayList<ImagesResponse>

    @GET("images/{image_id}")
    suspend fun getCatImageById(@Path("image_id") imageId: String): Cat

    @GET("images/{image_id}")
    suspend fun getCatImageById(
        @Path("image_id") imageId: String,
        @Query("sub_id") subId: String,
        @Query("size") size: Short,
        @Query("include_vote") includeVote: Boolean,
        @Query("include_favorites") includeFavorites: Boolean
    ): Cat
}