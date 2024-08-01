package com.example.galleryapp.features.screen.charactersdetail

import androidx.lifecycle.SavedStateHandle
import com.example.galleryapp.data.model.Result
import com.example.galleryapp.domain.viewstate.IViewEvent
import com.example.galleryapp.domain.viewstate.charactersdetail.CharactersDetailViewState
import com.example.galleryapp.features.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<CharactersDetailViewState, CharactersDetailViewEvent>() {

    init {
        savedStateHandle.get<String>("characterDetail")?.let {
            setState { currentState.copy(isLoading = false, data = Result.create(it)) }
        } ?: kotlin.run {
           setEvent(CharactersDetailViewEvent.SnackBarError("Something went wrong"))
        }
    }

    override fun createInitialState() = CharactersDetailViewState()
    override fun onTriggerEvent(event: CharactersDetailViewEvent) {}
}

sealed class CharactersDetailViewEvent : IViewEvent {
    class SnackBarError(val message: String?) : CharactersDetailViewEvent()
}