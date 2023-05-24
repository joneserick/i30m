package br.com.stefick.i30m.features.images.presentation

import br.com.stefick.i30m.features.images.models.Cat

interface CatImagesContract {
    interface View {
        fun displayCats(cats: List<Cat>)
        fun goToCatDetails()
        fun displayError(error: Throwable)
        fun showLoading()
        fun dismissLoading()
    }

    interface Presenter {
        fun loadCatImages(limit: Int, hasBreeds: Int)
        fun getCatDetail(imageId: String)
    }
}