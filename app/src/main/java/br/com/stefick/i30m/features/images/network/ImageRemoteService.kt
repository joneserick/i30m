package br.com.stefick.i30m.features.images.network

import br.com.stefick.i30m.features.breed.network.ServiceFactory
import br.com.stefick.i30m.features.images.models.Cat
import br.com.stefick.i30m.features.images.models.ImagesResponse

class ImageRemoteService : ImagesDataSource, ServiceFactory<ImagesApi>(ImagesApi::class.java) {

    override suspend fun getCatImages(limit: Int, hasBreeds: Int): ArrayList<ImagesResponse> =
        api.getCatImages(limit, hasBreeds)


    override suspend fun getCatImageById(imageId: String): Cat =
        api.getCatImageById(imageId)

    override suspend fun getCatImageById(
        imageId: String,
        subId: String,
        size: Short,
        includeVote: Boolean,
        includeFavorites: Boolean
    ): Cat =
        api.getCatImageById(imageId, subId, size, includeVote, includeFavorites)

}