package br.com.stefick.i30m.features.breed.network

import br.com.stefick.i30m.features.breed.models.BreedResponse

interface BreedRemoteDataSource {
    suspend fun getBreeds(limit: Int, page: Int): ArrayList<BreedResponse>
    suspend fun getBreed(breedId: Int): BreedResponse
}
