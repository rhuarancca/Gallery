package com.example.galleryapp.domain.viewstate.episodes

import androidx.compose.runtime.Stable
import com.example.galleryapp.data.model.EpisodesResultResponse
import com.example.galleryapp.domain.viewstate.IViewState

@Stable
data class EpisodesViewState(
    val isLoading: Boolean = false,
    val data: List<EpisodesResultResponse>? = null
) : IViewState