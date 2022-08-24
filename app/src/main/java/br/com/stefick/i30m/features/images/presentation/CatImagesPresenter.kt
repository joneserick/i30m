package br.com.stefick.i30m.features.images.presentation

import br.com.stefick.i30m.features.breed.models.Breed
import br.com.stefick.i30m.features.images.details.presentation.CatItemClickListener
import br.com.stefick.i30m.features.images.models.Cat
import br.com.stefick.i30m.features.images.network.IImageRepository
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class CatImagesPresenter(
    private val view: CatImagesContract.View,
    private val repository: IImageRepository,
    private val coroutineScope: CoroutineScope
) : CatImagesContract.Presenter, CatItemClickListener {

    override fun loadCatImages(limit: Int, hasBreeds: Int) {
        coroutineScope.launch {
            repository.getCatImages(limit, hasBreeds)
                .onStart { view.showLoading() }
                .onCompletion { view.dismissLoading() }
                .catch { error ->
                    view.displayError(error)
                }
                .collect { response ->
                    view.displayCats(response.map {
                        Cat(
                            id = it.id,
                            url = it.url,
                            categories = it.categories,
                            breeds = it.breeds
                        )
                    })
                }
        }
    }

    override fun getCatDetail(imageId: String) {
        coroutineScope.launch {
            repository.getCatImageById(imageId)
                .onStart { view.showLoading() }
                .onCompletion { view.dismissLoading() }
                .catch { error ->
                    view.displayError(error)
                }
                .collect { response ->
//                    view.displayCatDetails(response)
                }
        }
    }

    override fun onCatItemClick(cat: Cat) {
        view.goToCatDetails(cat.id)
    }

}