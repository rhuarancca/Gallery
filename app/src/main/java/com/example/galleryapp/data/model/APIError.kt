package com.example.galleryapp.data.model

import androidx.compose.runtime.Stable

@Stable
data class APIError(val code: Long, val message: String)
