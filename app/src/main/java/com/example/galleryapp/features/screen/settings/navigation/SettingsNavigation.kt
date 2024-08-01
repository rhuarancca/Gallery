@file:OptIn(ExperimentalAnimationApi::class)

package com.example.galleryapp.features.screen.settings.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import com.example.galleryapp.features.screen.settings.SettingsScreen

const val settingsNavigationRoute = "settings_route"

fun NavController.navigateToSettings(
    navOptions: NavOptions? = null
) {
    this.navigate(settingsNavigationRoute, navOptions)
}

fun NavGraphBuilder.settingsScreen() {
    composable(settingsNavigationRoute) {
        SettingsScreen(
            hiltViewModel()
        )
    }
}