package br.com.stefick.i30m.features.images.details.presentation

import br.com.stefick.i30m.features.images.details.network.ICatDetailsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CatDetailsPresenter(
    val view: CatDetailsContract.View,
    val repository: ICatDetailsRepository,
    val coroutineScope: CoroutineScope
) : CatDetailsContract.Presenter {

    fun getCatDetails(catId: String, breedId: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            val catDetails = async { repository.getCatDetails(catId) }
            val breedDetails = async { repository.getBreedDetails(breedId) }
        }
    }


}