package com.dss.praticalshimmer

import android.animation.TimeAnimator
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.Rect
import android.graphics.Shader
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.view.View

class ShimmerGradient(
    var view: View,
    var orientation: ShimmerOrientation,
    var interval: Int,
    var color1: Int,
    var color2: Int
) : Drawable(), Animatable, TimeAnimator.TimeListener {

    private val paint = Paint()
    private var x: Float = 0.toFloat()
    private val animator = TimeAnimator()


    init {
        animator.setTimeListener(this)
    }

    override fun onBoundsChange(bounds: Rect) {
        when (orientation) {
            ShimmerOrientation.Horizontal -> {
                paint.shader = LinearGradient(
                    0f, 0f, bounds.width().toFloat(),
                    0f, color1, color2, Shader.TileMode.MIRROR
                )
            }
            ShimmerOrientation.DiagonalDown -> {
                paint.shader = LinearGradient(
                    0f, 0f, bounds.width().toFloat(),
                    bounds.height().toFloat(), color1, color2, Shader.TileMode.MIRROR
                )
            }
            ShimmerOrientation.DiagonalUp -> {
                paint.shader = LinearGradient(
                    bounds.width().toFloat(), 0f, bounds.width().toFloat() / 2,
                    bounds.height().toFloat(), color1, color2, Shader.TileMode.MIRROR
                )
            }
        }
    }

    override fun draw(canvas: Canvas) {
        canvas.clipRect(bounds)
        canvas.translate(x, 0f)
        canvas.drawPaint(paint)
    }

    override fun setAlpha(alpha: Int) {}

    override fun setColorFilter(colorFilter: ColorFilter?) {}

    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT

    override fun start() {
        animator.start()
    }

    override fun stop() {
        animator.cancel()
    }

    override fun isRunning(): Boolean = animator.isRunning

    override fun onTimeUpdate(animation: TimeAnimator, totalTime: Long, deltaTime: Long) {

        x = view.width.toFloat() * totalTime / interval
        invalidateSelf()
    }
}