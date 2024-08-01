package com.example.galleryapp.features.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.galleryapp.R
import com.example.galleryapp.features.screen.characters.navigation.charactersNavigationRoute
import com.example.galleryapp.features.screen.episodes.navigation.episodesNavigationRoute
import com.example.galleryapp.features.screen.favorites.navigation.favoritesNavigationRoute
import com.example.galleryapp.features.screen.search.navigation.searchNavigationRoute
import com.example.galleryapp.features.screen.settings.navigation.settingsNavigationRoute

enum class BottomNav(
    val route: String,
    @DrawableRes val iconId: Int,
    @StringRes val titleTextId: Int
) {
    CHARACTERS(
        charactersNavigationRoute,
        R.drawable.ic_outline_people,
        R.string.characters_screen_title,
    ),
    EPISODES(
        episodesNavigationRoute,
        R.drawable.ic_baseline_movie_creation_24,
        R.string.episodes_screen_title
    ),
    FAVORITES(
        favoritesNavigationRoute,
        R.drawable.ic_baseline_favorite_24,
        R.string.favorite_screen_title,
    ),
    SEARCH(
        searchNavigationRoute,
        R.drawable.ic_baseline_search_24,
        R.string.search_screen_title,
    ),
    SETTINGS(
        settingsNavigationRoute,
        R.drawable.ic_baseline_settings,
        R.string.settings_screen_title
    )
}