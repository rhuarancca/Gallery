package com.example.galleryapp.domain.viewstate.charactersdetail

import androidx.compose.runtime.Stable
import com.example.galleryapp.data.model.Result
import com.example.galleryapp.domain.viewstate.IViewState


@Stable
data class CharactersDetailViewState(
    val isLoading: Boolean = false,
    val data: Result? = null
) : IViewState