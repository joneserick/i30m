package br.com.stefick.i30m.features.breed.network

import br.com.stefick.i30m.features.breed.models.BreedResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Path

interface IBreedRepository {
    suspend fun getBreeds(limit: Int, page: Int): Flow<ArrayList<BreedResponse>>
    suspend fun getBreed(@Path("id") breedId: Int): Flow<BreedResponse>
}
