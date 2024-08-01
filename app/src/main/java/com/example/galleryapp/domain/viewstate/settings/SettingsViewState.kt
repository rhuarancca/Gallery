package com.example.galleryapp.domain.viewstate.settings

import androidx.compose.runtime.Stable
import com.example.galleryapp.domain.viewstate.IViewState

@Stable
data class SettingsViewState(
    val isDark: Boolean = false,
) : IViewState