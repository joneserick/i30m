package br.com.stefick.i30m.shared.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.ViewOutlineProvider
import androidx.appcompat.widget.AppCompatImageView
import br.com.stefick.i30m.R

class CircleImageView : AppCompatImageView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )

    constructor(context: Context, attributeSet: AttributeSet?) : super(
        context,
        attributeSet
    )

    init {
        outlineProvider = ViewOutlineProvider.BACKGROUND
        clipToOutline = true
        setBackgroundResource(R.drawable.bg_circle)
        scaleType = ScaleType.CENTER_CROP
    }
}