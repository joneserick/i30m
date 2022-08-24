package br.com.stefick.i30m.features.breed.presentation

import br.com.stefick.i30m.features.breed.models.BreedDetails
import br.com.stefick.i30m.features.breed.models.BreedResponse

interface BreedContract {
    interface View {
        fun displayBreeds(breeds: ArrayList<BreedResponse>)
        fun displayLoading()
        fun dismissLoading()
        fun displayError(stringRest: Int)
        fun displayBreed(breed: BreedDetails)

    }

    interface Presenter {
        fun getBreeds(limit: Int, page: Int)
        fun getSingleBreed(breedId: Int)
        fun onDestroy()
    }
}