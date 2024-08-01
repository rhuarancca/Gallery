package com.example.galleryapp.domain.repository

import com.example.galleryapp.data.model.EpisodesResponse
import com.example.galleryapp.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {
    fun getAllEpisodes(): Flow<DataState<EpisodesResponse>>
    fun getEpisode(episodeId: Int): Flow<DataState<EpisodesResponse>>
}