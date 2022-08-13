package br.com.stefick.i30m.features.breed.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import br.com.stefick.i30m.databinding.FragmentBreedBinding
import br.com.stefick.i30m.features.breed.models.BreedResponse
import br.com.stefick.i30m.features.breed.network.BreedRepository
import br.com.stefick.i30m.features.breed.network.Service
import com.google.android.material.snackbar.Snackbar

class BreedFragment : Fragment(), BreedContract.View {

    private var mPresenter: BreedPresenter? = null
    private lateinit var mBinding: FragmentBreedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = BreedPresenter(
            this,
            BreedRepository(Service()),
            lifecycleScope
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentBreedBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.button.setOnClickListener {
            mPresenter?.getBreeds(10, 1)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BreedFragment()
    }

    override fun displayBreeds(breeds: ArrayList<BreedResponse>) {
        Snackbar.make(requireView(), "O numero de raças é: ${breeds.size}", Snackbar.LENGTH_LONG)
            .show()
    }

    override fun displayLoading() {
        Log.i("BreedFragment", "EXIBIR CARREGANDO")
    }

    override fun dismissLoading() {
        Log.i("BreedFragment", "ESCONDER CARREGANDO")
    }

    override fun displayError(stringRest: Int) {
        Snackbar.make(
            requireView(),
            "Erro: ${getString(stringRest)}",
            Snackbar.LENGTH_LONG
        ).show()
    }
}