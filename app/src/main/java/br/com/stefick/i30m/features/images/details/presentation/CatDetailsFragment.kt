package br.com.stefick.i30m.features.images.details.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import br.com.stefick.i30m.R
import br.com.stefick.i30m.databinding.FragmentCatDetailsBinding

class CatDetailsFragment : Fragment() {

    private lateinit var mNavController: NavController
    private lateinit var mBinding: FragmentCatDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNavController = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentCatDetailsBinding.inflate(inflater, container, false)
        setupView()
        return mBinding.root
    }

    private fun setupView() {
        mBinding.back.setOnClickListener { mNavController.navigateUp() }
    }

    companion object {
        fun newInstance() = CatDetailsFragment()
    }
}