package com.dss.praticalshimmer.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dss.praticalshimmer.ShimmerConfig
import com.dss.praticalshimmer.ShimmerRunner
import com.dss.praticalshimmer.sample.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    companion object{
        private const val TEST_INTERVAL = 300
    }

    private lateinit var binding : ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val shimmer = ShimmerConfig()
            .on(binding.viewContainer)
            .interval(TEST_INTERVAL)
            .disableClicks(false)
            .orientation(com.dss.praticalshimmer.ShimmerOrientation.Horizontal)
            .disableClicks(true)
            .addIgnoredView(binding.btnStop)

        binding.btnStart.setOnClickListener {
            ShimmerRunner.run(shimmer)
        }

        binding.btnStop.setOnClickListener {
            ShimmerRunner.stop(shimmer)
        }
    }
}