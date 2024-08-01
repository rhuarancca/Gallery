package com.example.galleryapp.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.example.galleryapp.features.component.BottomAppBar
import com.example.galleryapp.features.component.FloatingActionBar
import com.example.galleryapp.features.component.Scaffold
import com.example.galleryapp.features.screen.characters.navigation.charactersNavigationRoute
import com.example.galleryapp.features.screen.characters.navigation.charactersScreen
import com.example.galleryapp.features.screen.charactersdetail.navigation.charactersDetailScreen
import com.example.galleryapp.features.screen.charactersdetail.navigation.navigateCharactersDetail
import com.example.galleryapp.features.screen.episodes.navigation.episodesScreen
import com.example.galleryapp.features.screen.favorites.navigation.favoritesScreen
import com.example.galleryapp.features.screen.search.navigation.searchScreen
import com.example.galleryapp.features.screen.settings.navigation.settingsScreen
import com.example.galleryapp.utils.Utility.toJson

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph() {
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentDestination = navController
        .currentBackStackEntryAsState().value?.destination

    Scaffold(
        bottomBar = {
            BottomNav.values().forEach { navItem ->
                if (navItem.route == currentRoute) {
                    BottomAppBar(
                        navController = navController,
                        currentDestination = currentDestination
                    )
                }
            }
        },
        floatingActionButton = {
            BottomNav.values().forEach { navItem ->
                if (navItem.route == currentRoute) {
                    FloatingActionBar(
                        navController = navController,
                    )
                }
            }
        },
        backgroundColor = MaterialTheme.colors.background,
    ) { innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = charactersNavigationRoute,
            Modifier.padding(innerPadding)
        ) {
            charactersScreen { navController.navigateCharactersDetail(it.toJson()) }
            charactersDetailScreen { navController.navigateUp() }
            episodesScreen()
            searchScreen { navController.navigateCharactersDetail(it.toJson()) }
            settingsScreen()
            favoritesScreen { navController.navigateCharactersDetail(it.toJson()) }
        }
    }
}
