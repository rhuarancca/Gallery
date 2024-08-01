package com.example.galleryapp.features.screen.favorites

import androidx.lifecycle.viewModelScope
import com.example.galleryapp.domain.usecase.favorite.DeleteFavoriteUseCase
import com.example.galleryapp.domain.usecase.favorite.GetFavoritesUseCase
import com.example.galleryapp.domain.viewstate.IViewEvent
import com.example.galleryapp.features.component.favorites.FavoritesViewState
import com.example.galleryapp.features.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase
) : BaseViewModel<FavoritesViewState, FavoritesViewEvent>() {

    init {
        getFavorites()
    }

    private fun getFavorites() {
        viewModelScope.launch {
            setState { currentState.copy(isLoading = true) }
            delay(2000)
            val favoritesList = getFavoritesUseCase.repository.getFavoriteList()
            setState { currentState.copy(favoritesList = favoritesList, isLoading = false) }
        }
    }

    override fun onTriggerEvent(event: FavoritesViewEvent) {
        viewModelScope.launch {
            when (event) {
                is FavoritesViewEvent.OnDeleteFavorite -> {
                    onDeleteFavorite()
                }
                is FavoritesViewEvent.OnDisplayChange -> {
                    setState {
                        currentState.copy(
                            isDisplay = event.isDisplay,
                            favoriteId = event.favoriteId
                        )
                    }
                }
                is FavoritesViewEvent.OnDeleteAllFavorites -> {
                    deleteAllFavorites()
                }
                is FavoritesViewEvent.OnIsDeleteAllFavoritesChange -> {
                    setState {
                        currentState.copy(
                            isDisplay = true,
                            isAllDeleteFavorites = true
                        )
                    }

                }
            }
        }
    }

    private fun onDeleteFavorite() {
        viewModelScope.launch {
            currentState.favoriteId?.let {
                call(deleteFavoriteUseCase(DeleteFavoriteUseCase.Params(it)))
                updateFavoriteList()
            }
        }
    }

    private fun deleteAllFavorites() {
        viewModelScope.launch {
            call(deleteFavoriteUseCase(DeleteFavoriteUseCase.Params(null)))
            updateFavoriteList()
            setState { currentState.copy(isAllDeleteFavorites = false) }
        }
    }

    private fun updateFavoriteList() {
        viewModelScope.launch {
            val favoritesList = getFavoritesUseCase.repository.getFavoriteList()
            setState { currentState.copy(favoritesList = favoritesList, isLoading = false) }
        }
    }

    override fun createInitialState() = FavoritesViewState()
}

sealed class FavoritesViewEvent : IViewEvent {
    class OnDisplayChange(val isDisplay: Boolean, val favoriteId: Int?) : FavoritesViewEvent()
    object OnDeleteFavorite : FavoritesViewEvent()
    object OnDeleteAllFavorites : FavoritesViewEvent()
    object OnIsDeleteAllFavoritesChange : FavoritesViewEvent()
}