package com.example.galleryapp.features.screen.settings

import androidx.lifecycle.viewModelScope
import com.example.galleryapp.GalleryApp
import com.example.galleryapp.domain.viewstate.IViewEvent
import com.example.galleryapp.domain.viewstate.settings.SettingsViewState
import com.example.galleryapp.features.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val application: GalleryApp
) : BaseViewModel<SettingsViewState, SettingsViewEvent>() {

    init {
        setState { currentState.copy(isDark = application.isDark.value) }
    }

   private fun onChangeTheme() {
        viewModelScope.launch {
            application.toggleTheme()
            setState { currentState.copy(isDark = application.isDark.value) }
        }
    }

    override fun onTriggerEvent(event: SettingsViewEvent) {
        viewModelScope.launch {
            when (event) {
                is SettingsViewEvent.OnChangeTheme -> onChangeTheme()
            }
        }
    }

    override fun createInitialState() = SettingsViewState()
}

sealed class SettingsViewEvent : IViewEvent {
    object OnChangeTheme : SettingsViewEvent()
}
