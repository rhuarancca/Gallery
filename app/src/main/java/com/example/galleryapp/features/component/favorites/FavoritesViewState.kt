package com.example.galleryapp.features.component.favorites

import androidx.compose.runtime.Stable
import com.example.galleryapp.data.model.FavoriteEntity
import com.example.galleryapp.domain.viewstate.IViewState

@Stable
data class FavoritesViewState(
    val favoritesList: List<FavoriteEntity> = emptyList(),
    val favoriteId: Int? = null,
    val isDisplay: Boolean = false,
    val isAllDeleteFavorites: Boolean = false,
    val isLoading: Boolean = false,
) : IViewState