package br.com.stefick.i30m.features.images.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import br.com.stefick.i30m.databinding.FragmentCatListBinding
import br.com.stefick.i30m.features.images.models.ImagesResponse
import br.com.stefick.i30m.features.images.network.ImageRemoteService
import br.com.stefick.i30m.features.images.network.ImageRepository

class CatListFragment : Fragment(), CatImagesContract.View {

    private lateinit var mBinding: FragmentCatListBinding
    private lateinit var mPresenter: CatImagesPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentCatListBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter = CatImagesPresenter(this, ImageRepository(ImageRemoteService()), lifecycleScope)
        mBinding.btRequestCats.setOnClickListener {
            mPresenter.loadCatImages()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CatListFragment()
    }

    override fun displayCats(images: ArrayList<ImagesResponse>) {

    }

    override fun goToCatDetails() {
    }

    override fun displayError(error: Throwable) {
        error.printStackTrace()
    }

    override fun showLoading() {
        mBinding.loading.visibility = View.VISIBLE
    }

    override fun dismissLoading() {
        mBinding.loading.visibility = View.GONE
    }
}