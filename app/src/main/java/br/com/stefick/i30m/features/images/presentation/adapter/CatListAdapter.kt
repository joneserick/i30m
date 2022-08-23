package br.com.stefick.i30m.features.images.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.stefick.i30m.R
import br.com.stefick.i30m.databinding.ViewItemCatListBinding
import br.com.stefick.i30m.features.images.models.Cat
import com.bumptech.glide.Glide

class CatListAdapter(private val context: Context) :
    RecyclerView.Adapter<CatListAdapter.CatViewHolder>() {

    private var mItems: List<Cat> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            ViewItemCatListBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = mItems.size


    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(mItems[position])
    }

    fun addAll(cats: List<Cat>) {
        if (mItems.isEmpty())
            mItems = cats
    }

    class CatViewHolder(val binding: ViewItemCatListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cat: Cat) {
            Glide.with(binding.root)
                .load(cat.url)
                .centerCrop()
                .placeholder(R.drawable.loading_animation)
                .into(binding.catImage)
            if (cat.breeds?.isEmpty() != false) {
                binding.categoryLabel.text =
                    cat.breeds?.first { it.name.isNotBlank() }?.name.toString()
            }
            binding.breedName.text = cat.id
        }
    }

}