@file:OptIn(ExperimentalAnimationApi::class)

package com.example.galleryapp.features.screen.search.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import com.example.galleryapp.data.model.dto.CharacterDto
import com.example.galleryapp.features.screen.search.SearchScreen


const val searchNavigationRoute = "search_route"

fun NavController.navigateToSearch(
    navOptions: NavOptions? = null
) {
    this.navigate(searchNavigationRoute, navOptions)
}

fun NavGraphBuilder.searchScreen(navigateToDetail: (CharacterDto?) -> Unit) {
    composable(searchNavigationRoute) {
        SearchScreen(
            hiltViewModel(),
            navigateToDetail = {
                navigateToDetail.invoke(it)
            }
        )
    }
}