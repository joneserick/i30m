package br.com.stefick.i30m.features.breed.network

import br.com.stefick.i30m.features.breed.models.BreedResponse

class Service() : ServiceFactory<BreedApi>(BreedApi::class.java), BreedRemoteDataSource {

    override suspend fun getBreeds(limit: Int, page: Int): ArrayList<BreedResponse> =
        api.getBreeds(limit, page)

    override suspend fun getBreed(breedId: Int): BreedResponse =
        api.getBreed(breedId)
}