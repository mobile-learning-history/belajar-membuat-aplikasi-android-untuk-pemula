package com.example.submission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Set up an OnPreDrawListener to the root view.
    val content: View = findViewById(android.R.id.content)
    content.viewTreeObserver.addOnPreDrawListener(
    object : ViewTreeObserver.OnPreDrawListener {
        override fun onPreDraw(): Boolean {
            // Check whether the initial data is ready.
            return if (viewModel.isReady) {
                // The content is ready. Start drawing.
                content.viewTreeObserver.removeOnPreDrawListener(this)
                true
            } else {
                // The content isn't ready. Suspend.
                false
            }
        }
    }
    )

}