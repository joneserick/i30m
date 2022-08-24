package br.com.stefick.i30m.features.images.presentation

import br.com.stefick.i30m.features.images.models.Cat
import br.com.stefick.i30m.features.images.models.ImagesResponse

interface CatImagesContract {
    interface View {
        fun displayCats(cats: List<Cat>)
        fun goToCatDetails(catId: CharSequence)
        fun displayError(error: Throwable)
        fun showLoading()
        fun dismissLoading()
    }

    interface Presenter {
        fun loadCatImages(limit: Int, hasBreeds: Int)
        fun getCatDetail(imageId: String)
    }
}