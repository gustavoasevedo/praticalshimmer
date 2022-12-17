package com.dss.praticalshimmer.sample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.dss.praticalshimmer.ShimmerConfig
import com.dss.praticalshimmer.ShimmerRunner

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val viewContainer = findViewById<ConstraintLayout>(R.id.viewContainer)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnStop = findViewById<Button>(R.id.btnStop)

        val shimmer = ShimmerConfig()
            .on(viewContainer)
            .interval(300)
            .disableClicks(false)
            .orientation(com.dss.praticalshimmer.ShimmerOrientation.Horizontal)
            .disableClicks(true)
            .addIgnoredView(btnStop)

        btnStart.setOnClickListener {
            ShimmerRunner.run(shimmer)
        }

        btnStop.setOnClickListener {
            ShimmerRunner.stop(shimmer)
        }
    }
}