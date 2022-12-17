package com.dss.praticalshimmer

import android.view.View

object ShimmerRunner {
    fun run(shimmerConfig: ShimmerConfig) {
        for (view in shimmerConfig.childViews) {
            if (view !in shimmerConfig.ignoredViews) {
                animateGradient(view, shimmerConfig)
                if (shimmerConfig.disable) {
                    view.isClickable = false
                }
            }
        }
    }

    fun stop(shimmerConfig: ShimmerConfig) {
        for (view in shimmerConfig.childViews) {
            if (view !in shimmerConfig.ignoredViews) {
                removeGradient(view)
                if (shimmerConfig.disable) {
                    view.isClickable = true
                }
            }
        }
    }

    private fun animateGradient(view: View, shimmerConfig: ShimmerConfig) {

        val gradient = ShimmerGradient(
            view = view,
            interval = shimmerConfig.interval,
            orientation = shimmerConfig.orientation,
            color1 = shimmerConfig.color1,
            color2 = shimmerConfig.color2
        )

        view.foreground = gradient
        gradient.start()
    }

    private fun removeGradient(view: View) {
        view.foreground = null
    }
}