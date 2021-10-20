package br.com.kyberbooks.components

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.annotation.IntDef
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import br.com.kyberbooks.R

class KyberButton @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet? = null,
    defAttrSet: Int = 0
) : AppCompatButton(context, attrSet, defAttrSet) {

    companion object {

        private const val CONTAINED = 0
        private const val OUTLINED = 1
        private const val ONLY_TEXT = 2
    }

    init {
        val typedArray = context.obtainStyledAttributes(attrSet, R.styleable.KyberButton)

        height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40f, context.resources.displayMetrics).toInt()
        gravity = Gravity.CENTER
        textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 18f, context.resources.displayMetrics)

        val buttonType = typedArray.getInt(R.styleable.KyberButton_buttonType, CONTAINED)
        setupButtonStyle(buttonType)

        typedArray.recycle()

    }

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(CONTAINED, OUTLINED, ONLY_TEXT)
    annotation class ButtonType

    private fun setupButtonStyle(@ButtonType buttonType: Int) {
        when (buttonType) {
            CONTAINED -> {
                setBackgroundResource(R.drawable.bg_kyber_contained_button)
                setTextColor(ContextCompat.getColor(context, R.color.base_white))
            }
            OUTLINED -> {
                setBackgroundResource(R.drawable.bg_kyber_outlined_button)
                setTextColor(ContextCompat.getColor(context, R.color.purple_500))
            }
            ONLY_TEXT -> {
                background = ContextCompat.getDrawable(context, R.drawable.bg_kyber_outlined_button)
            }
        }
    }
}