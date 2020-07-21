package com.devfptpoly.admin.localcachewithretrofitroomdb.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation

class HorizontalDottedProgress(
    context: Context?,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private var mDotRadius: Int = 5

    private var mBounceDotRadius: Int = 8

    private var mDotPosition: Int = 0

    private var mDotAmount: Int = 10

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint: Paint = Paint()
        paint.color = Color.parseColor("#fd583f")
        createDot(canvas, paint)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        /**
         * Animation will be called when attaching to the window, i.e to your screen
         */
        startAnimation()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var width: Int
        var height: Int

        var calculatedWidth: Int = (20 * 9)

        width = calculatedWidth;
        height = (mBounceDotRadius * 2);

        /**
         * README: Must call this
         */
        setMeasuredDimension(width, height)
    }

    private fun startAnimation() {
        val bounceAnimation = BounceAnimation(this)
        bounceAnimation.duration = 100
        bounceAnimation.repeatCount = Animation.INFINITE
        bounceAnimation.interpolator = LinearInterpolator()
        bounceAnimation.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {}
            override fun onAnimationRepeat(animation: Animation) {
                mDotPosition++
                //when mDotPosition == mDotAmount , then start again applying animation from 0th positon , i.e  mDotPosition = 0;
                if (mDotPosition == mDotAmount) {
                    mDotPosition = 0
                }
                Log.d("INFOMETHOD", "----On Animation Repeat----")
            }
        })
        startAnimation(bounceAnimation)
    }

    private fun createDot(canvas: Canvas?, paint: Paint) {
        for (i in 0..mDotAmount) {
            if (i == mDotPosition) {
                canvas?.drawCircle(
                    (10 + (i * 20)).toFloat(),
                    (mBounceDotRadius).toFloat(),
                    (mBounceDotRadius).toFloat(),
                    paint
                )
            } else {
                canvas?.drawCircle(
                    (10 + (i * 20)).toFloat(),
                    (mBounceDotRadius).toFloat(),
                    (mDotRadius).toFloat(),
                    paint
                );
            }
        }
    }

    private class BounceAnimation(horizontalDottedProgress: HorizontalDottedProgress) :
        Animation() {
        var horizontal = horizontalDottedProgress
        override fun applyTransformation(
            interpolatedTime: Float,
            t: Transformation
        ) {
            super.applyTransformation(interpolatedTime, t)
            //call invalidate to redraw your view againg.
            horizontal?.invalidate()
        }
    }
}