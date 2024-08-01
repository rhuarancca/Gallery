package com.example.galleryapp.data.model

import androidx.compose.runtime.Stable

data class CharacterInfoResponse(
    val created: String?,
    val episode: List<String>?,
    val gender: String?,
    val id: Int?,
    val image: String?,
    val location: LocationResponse?,
    val name: String?,
    val origin: OriginResponse?,
    val species: String?,
    val status: Status?,
    val type: String?,
    val url: String?
)
