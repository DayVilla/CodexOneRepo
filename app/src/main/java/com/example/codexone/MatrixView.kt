package com.example.codexone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View
import kotlin.random.Random

class MatrixView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.GREEN
        textSize = 20f * resources.displayMetrics.density
        typeface = Typeface.MONOSPACE
    }

    private val charHeight: Float = paint.textSize
    private var columns: Int = 0
    private var offsets: FloatArray = FloatArray(0)
    private val random = Random

    private val handler = Handler(Looper.getMainLooper())
    private val updateRunnable = object : Runnable {
        override fun run() {
            for (i in offsets.indices) {
                offsets[i] += charHeight
                if (offsets[i] > height) offsets[i] = 0f
            }
            invalidate()
            handler.postDelayed(this, 50)
        }
    }

    init {
        handler.post(updateRunnable)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val charWidth = paint.measureText("0")
        columns = (w / charWidth + 1).toInt()
        offsets = FloatArray(columns) { random.nextFloat() * h }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val charWidth = paint.measureText("0")
        for (i in 0 until columns) {
            var y = offsets[i]
            while (y > -charHeight) {
                val c = randomChar()
                canvas.drawText(c.toString(), i * charWidth, y, paint)
                y -= charHeight
            }
        }
    }

    private fun randomChar(): Char {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        return chars[random.nextInt(chars.length)]
    }
}
