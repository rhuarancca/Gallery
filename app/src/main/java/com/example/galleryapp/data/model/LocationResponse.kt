package com.example.galleryapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationResponse(
    val name: String?,
    val url: String?
) : Parcelable
