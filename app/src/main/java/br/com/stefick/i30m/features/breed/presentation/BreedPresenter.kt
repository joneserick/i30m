package br.com.stefick.i30m.features.breed.presentation

import android.accounts.NetworkErrorException
import androidx.lifecycle.LifecycleCoroutineScope
import br.com.stefick.i30m.R
import br.com.stefick.i30m.features.breed.network.BreedRepository
import br.com.stefick.i30m.features.breed.network.IBreedRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.util.concurrent.TimeoutException

class BreedPresenter(
    private val view: BreedContract.View,
    private val repository: IBreedRepository,
    private val coroutineScope: CoroutineScope
) : BreedContract.Presenter {

    override fun getBreeds(limit: Int, page: Int) {
        coroutineScope.launch {
            repository.getBreeds(limit, page)
                .onStart { view.displayLoading() }
                .onCompletion { view.dismissLoading() }
                .catch { error ->
                    error.printStackTrace()
                    when (error) {
                        is NetworkErrorException -> view.displayError(R.string.network_error_msg)
                        is TimeoutException -> view.displayError(R.string.timeout_error_msg)
                        else -> view.displayError(R.string.generic_error_message)
                    }
                }
                .collect { breeds ->
                    view.displayBreeds(breeds)
                }
        }
    }

    override fun getSingleBreed(breedId: Int) {
        coroutineScope.launch {
            repository.getBreed(breedId)
                .onStart { view.displayLoading() }
                .onCompletion { view.dismissLoading() }
                .catch { error ->
                    error.printStackTrace()
                    when (error) {
                        is NetworkErrorException -> view.displayError(R.string.network_error_msg)
                        is TimeoutException -> view.displayError(R.string.timeout_error_msg)
                        else -> view.displayError(R.string.generic_error_message)
                    }
                }
                .collect { breeds ->
                    view.displayBreed(breeds)
                }
        }
    }


    override fun onDestroy() {
    }

}