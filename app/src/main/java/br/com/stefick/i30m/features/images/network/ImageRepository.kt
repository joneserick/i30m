package br.com.stefick.i30m.features.images.network

import br.com.stefick.i30m.features.images.models.Cat
import br.com.stefick.i30m.features.images.models.ImagesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ImageRepository(private val remoteDataSource: ImagesDataSource) : IImageRepository {

    override suspend fun getCatImages(limit: Int, hasBreeds: Int): Flow<ArrayList<ImagesResponse>> {
        return flow {
            emit(remoteDataSource.getCatImages(limit, hasBreeds))
        }
    }

    override suspend fun getCatImageById(imageId: String): Flow<Cat> {
        return flow {
            emit(remoteDataSource.getCatImageById(imageId))
        }
    }

    override suspend fun getCatImageById(
        imageId: String,
        subId: String,
        size: Short,
        includeVote: Boolean,
        includeFavorites: Boolean
    ): Flow<Cat> {
        return flow {
            emit(
                remoteDataSource.getCatImageById(
                    imageId,
                    subId,
                    size,
                    includeVote,
                    includeFavorites
                )
            )
        }
    }

}