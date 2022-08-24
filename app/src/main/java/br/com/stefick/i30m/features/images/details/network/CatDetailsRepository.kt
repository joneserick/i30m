package br.com.stefick.i30m.features.images.details.network

import br.com.stefick.i30m.features.breed.models.BreedDetails
import br.com.stefick.i30m.features.breed.network.BreedRemoteDataSource
import br.com.stefick.i30m.features.images.models.Cat
import br.com.stefick.i30m.features.images.network.ImagesDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CatDetailsRepository(
    private val catDataSource: ImagesDataSource,
    private val breedDataSource: BreedRemoteDataSource
) : ICatDetailsRepository {

    override suspend fun getCatDetails(catId: String): Flow<Cat> {
        return flow {
            emit(catDataSource.getCatImageById(catId))
        }
    }

    override suspend fun getBreedDetails(breedId: Int): Flow<BreedDetails> {
        return flow {
            emit(breedDataSource.getBreed(breedId))
        }
    }
}