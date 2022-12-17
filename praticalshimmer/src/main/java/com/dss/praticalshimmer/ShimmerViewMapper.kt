package com.dss.praticalshimmer

import android.view.View
import android.view.ViewGroup

object ShimmerViewMapper {

    fun mapChildViews(v: View): ArrayList<View> {
        val listViews = ArrayList<View>()
        if (v is ViewGroup) {
            for (i in 0 until v.childCount) {
                val v1 = v.getChildAt(i)

                if (v1 is ViewGroup) listViews.addAll(mapChildViews(v1))
                else listViews.add(v1)
            }
        } else {
            listViews.add(v)
        }

        return listViews
    }
}