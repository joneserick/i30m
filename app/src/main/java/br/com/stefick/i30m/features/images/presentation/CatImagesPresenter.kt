package br.com.stefick.i30m.features.images.presentation

import br.com.stefick.i30m.features.images.network.IImageRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CatImagesPresenter(
    val view: CatImagesContract.View,
    val repository: IImageRepository,
    val coroutineScope: CoroutineScope
) : CatImagesContract.Presenter {

    override fun loadCatImages() {
        coroutineScope.launch {
            repository.getCatImages()
                .onStart { view.showLoading() }
                .onCompletion { view.dismissLoading() }
                .catch { error ->
                    view.displayError(error)
                }
                .collect { response ->
                    view.displayCats(response)
                }
        }
    }

    override fun getCatDetail(imageId: String) {
        TODO("Not yet implemented")
    }


}