package br.com.stefick.i30m.features.images.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.stefick.i30m.databinding.FragmentCatListBinding
import br.com.stefick.i30m.features.images.models.Cat
import br.com.stefick.i30m.features.images.network.ImageRemoteService
import br.com.stefick.i30m.features.images.network.ImageRepository
import br.com.stefick.i30m.features.images.presentation.adapter.CatListAdapter

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
        mPresenter.loadCatImages(20, 1)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CatListFragment()
    }

    override fun displayCats(cats: List<Cat>) {
        val safeContext = context ?: return

        val catAdapter = CatListAdapter(safeContext).apply {
            addAll(cats)
        }
        mBinding.catList.apply {
            adapter = catAdapter
            layoutManager =
                LinearLayoutManager(safeContext, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun goToCatDetails() {
    }

    override fun displayError(error: Throwable) {
        error.printStackTrace()
    }

    override fun showLoading() {
        mBinding.loadingProgress.visibility = View.VISIBLE
    }

    override fun dismissLoading() {
        mBinding.loadingProgress.visibility = View.GONE
    }
}