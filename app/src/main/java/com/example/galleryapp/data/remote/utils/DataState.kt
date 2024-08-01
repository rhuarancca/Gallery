package com.example.galleryapp.data.remote.utils

import com.example.galleryapp.data.model.APIError


sealed class DataState<T> {
    class Success<T>(val data: T) : DataState<T>()
    class Loading<T> : DataState<T>()
    class Error<T>(val apiError: APIError?) : DataState<T>()
}