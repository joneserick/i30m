package br.com.stefick.i30m.features.breed.network

import br.com.stefick.i30m.features.breed.models.BreedDetails
import br.com.stefick.i30m.features.breed.models.BreedResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BreedApi {

    @GET("breeds")
    suspend fun getBreeds(@Query("limit") limit: Int, @Query("page") page: Int): ArrayList<BreedResponse>

    @GET("breeds/{id}")
    suspend fun getBreed(@Path("id") breedId: Int): BreedDetails
}