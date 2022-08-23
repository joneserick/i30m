package br.com.stefick.i30m.features.images.network

import br.com.stefick.i30m.features.images.models.Cat
import br.com.stefick.i30m.features.images.models.ImagesResponse
import retrofit2.http.Path
import retrofit2.http.Query

interface ImagesDataSource {

    suspend fun getCatImages(limit: Int, hasBreeds: Int): ArrayList<ImagesResponse>

    suspend fun getCatImageById(@Path("image_id") imageId: String): Cat

    suspend fun getCatImageById(
        @Path("image_id") imageId: String,
        @Query("sub_id") subId: String,
        @Query("size") size: Short,
        @Query("include_vote") includeVote: Boolean,
        @Query("include_favorites") includeFavorites: Boolean
    ): Cat
}