package com.example.galleryapp.features.screen.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.galleryapp.features.screen.main.MainActivity
import com.example.galleryapp.utils.Utility.launchActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val viewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { true }

        lifecycleScope.launchWhenCreated {
            viewModel.uiEvent.collect {
                when (it) {
                    is SplashViewEvent.DirectToDashBoard -> {
                        startMainActivity()
                        finish()
                    }

                    else -> {}
                }
            }
        }
    }


    private fun startMainActivity() {
        launchActivity(
            packageName = packageName,
            className = MainActivity::class.java.name
        )
    }
}