package br.com.stefick.i30m.features.images.details.presentation

import br.com.stefick.i30m.features.images.models.Cat

interface CatItemClickListener {
    fun onCatItemClick(cat: Cat)
}
