package br.com.stefick.i30m.features.images.details.network

import br.com.stefick.i30m.features.breed.models.BreedDetails
import br.com.stefick.i30m.features.images.models.Cat
import kotlinx.coroutines.flow.Flow

interface ICatDetailsRepository {

    suspend fun getCatDetails(catId: String): Flow<Cat>

    suspend fun getBreedDetails(breedId: Int): Flow<BreedDetails>

}