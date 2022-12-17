package com.dss.praticalshimmer

import android.graphics.Color
import android.view.View

class ShimmerConfig {

    companion object{
        const val SHIMMER_DEFAULT_INTERVAL = 1000
    }

    private lateinit var groupView: View
    lateinit var childViews: ArrayList<View>
    lateinit var orientation: ShimmerOrientation
    var interval = SHIMMER_DEFAULT_INTERVAL
    var ignoredViews = ArrayList<View>()
    var disable = true
    var color1 = Color.LTGRAY
    var color2 = Color.WHITE

    fun on(view: View): ShimmerConfig {
        this.groupView = view
        this.childViews = ShimmerViewMapper.mapChildViews(view)
        return this
    }

    fun orientation(orientation: ShimmerOrientation): ShimmerConfig {
        this.orientation = orientation
        return this
    }

    fun interval(interval: Int): ShimmerConfig {
        this.interval = interval
        return this
    }

    fun disableClicks(disable: Boolean): ShimmerConfig {
        this.disable = disable
        return this
    }

    fun addIgnoredView(view: View): ShimmerConfig {
        this.ignoredViews.add(view)
        return this
    }

    fun addIgnoredView(views: ArrayList<View>): ShimmerConfig {
        this.ignoredViews.addAll(views)
        return this
    }

    fun removeIgnoredView(view: View): ShimmerConfig {
        this.ignoredViews.remove(view)
        return this
    }

    fun removeIgnoredView(views: ArrayList<View>): ShimmerConfig {
        this.ignoredViews.removeAll(views)
        return this
    }

    fun removeAllIgnoredViews(): ShimmerConfig {
        this.ignoredViews = ArrayList()
        return this
    }

    fun setShimmerColors(color1: Int, color2: Int): ShimmerConfig {
        this.color1 = color1
        this.color2 = color2
        return this
    }


}