package com.example.galleryapp.domain.viewstate.characters

import androidx.compose.runtime.Stable
import androidx.paging.PagingData
import com.example.galleryapp.data.model.Result
import com.example.galleryapp.data.model.dto.CharacterDto
import com.example.galleryapp.domain.viewstate.IViewState
import kotlinx.coroutines.flow.Flow

@Stable
data class CharactersViewState(
    val isLoading: Boolean = false,
    val pagedData: Flow<PagingData<CharacterDto>>? = null,
    val data: List<Result>? = null,
) : IViewState