package com.example.galleryapp.domain.viewstate.splash

import androidx.compose.runtime.Stable
import com.example.galleryapp.domain.viewstate.IViewState

@Stable
data class SplashViewState(
    val isLoading: Boolean = false
) : IViewState