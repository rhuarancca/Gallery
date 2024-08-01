package com.example.galleryapp.domain.viewstate.search

import android.os.Parcelable
import androidx.compose.runtime.Stable
import androidx.paging.PagingData
import com.example.galleryapp.data.model.Status
import com.example.galleryapp.data.model.dto.CharacterDto
import com.example.galleryapp.domain.viewstate.IViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.parcelize.Parcelize

@Stable
data class SearchViewState(
    val searchText: String? = null,
    val pagedData: Flow<PagingData<CharacterDto>>? = null,
    val status: List<CharacterStatus> = listOf(
        CharacterStatus(Status.Alive.value, false),
        CharacterStatus(Status.Dead.value, false),
        CharacterStatus(Status.Unknown.value, false)
    ),
    val gender: List<CharacterGender> = listOf(
        CharacterGender("female", false),
        CharacterGender("male", false),
        CharacterGender("genderless", false),
        CharacterGender("unknown", false)
    ),
    val isLoading: Boolean = false
) : IViewState

@Parcelize
data class CharacterStatus(
    val name: String,
    val selected: Boolean,
) : Parcelable

@Parcelize
data class CharacterGender(
    val name: String,
    val selected: Boolean,
) : Parcelable
