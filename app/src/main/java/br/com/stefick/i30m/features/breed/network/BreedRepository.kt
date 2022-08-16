package br.com.stefick.i30m.features.breed.network

import br.com.stefick.i30m.features.breed.models.BreedResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class BreedRepository(private val remoteDataSource: BreedRemoteDataSource) : IBreedRepository {

    override suspend fun getBreeds(limit: Int, page: Int): Flow<ArrayList<BreedResponse>> {
        return withContext(Dispatchers.IO) {
            flow {
                emit(remoteDataSource.getBreeds(limit, page))
            }
        }
    }

    override suspend fun getBreed(breedId: Int): Flow<BreedResponse> {
        return withContext(Dispatchers.IO) {
            flow {
                emit(remoteDataSource.getBreed(breedId))
            }
        }
    }

}