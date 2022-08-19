package br.com.stefick.i30m.features.images.presentation

import br.com.stefick.i30m.features.images.models.Cat
import br.com.stefick.i30m.features.images.models.ImagesResponse

interface CatImagesContract {
    interface View {
        fun displayCats(images: ArrayList<ImagesResponse>)
        fun goToCatDetails()
        fun displayError(error: Throwable)
        fun showLoading()
        fun dismissLoading()
    }

    interface Presenter {
        fun loadCatImages()
        fun getCatDetail(imageId: String)
    }
}