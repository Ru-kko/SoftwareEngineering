package com.taller02.componets

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.taller02.R
import kotlin.math.min

class AccountIconImage @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val borderPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val borderWidth = 5f * resources.displayMetrics.density
    private var bitmap: Bitmap? = null

    init {
        borderPaint.color = ContextCompat.getColor(context, R.color.orange)
        borderPaint.style = Paint.Style.STROKE
        borderPaint.strokeWidth = borderWidth

        backgroundPaint.color = ContextCompat.getColor(context, R.color.white)
        backgroundPaint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        val size = min(width, height).toFloat()
        val radius = size / 2f
        val imageRadius = radius - (borderWidth / 2)

        canvas.drawCircle(radius, radius, imageRadius, backgroundPaint)
        getScaledBitMap().let {
            val shader = BitmapShader(it, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
            paint.shader = shader

            canvas.drawCircle(radius, radius, imageRadius, paint)
            canvas.drawCircle(radius, radius, imageRadius, borderPaint)
        }
    }

    fun setImage(bitmap: Bitmap) {
        this.bitmap = bitmap
        invalidate()
    }

    private fun getScaledBitMap(): Bitmap {
        val save = bitmap // * keeps the pointer
        if (save !== null) {
            return Bitmap.createScaledBitmap(save, width, height, true)
        }

        return getDrawable().toBitmap(width, height, Bitmap.Config.ARGB_8888)
    }
}