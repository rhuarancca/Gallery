@file:OptIn(ExperimentalAnimationApi::class)

package com.example.galleryapp.features.screen.episodes.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import com.example.galleryapp.data.model.dto.CharacterDto
import com.example.galleryapp.features.screen.episodes.EpisodesScreen

const val episodesNavigationRoute = "episodes_route"

fun NavController.navigateToEpisodes(
    navOptions: NavOptions? = null
) {
    this.navigate(episodesNavigationRoute, navOptions)
}

fun NavGraphBuilder.episodesScreen() {
    composable(episodesNavigationRoute) {
        EpisodesScreen(
            hiltViewModel()
        )
    }
}