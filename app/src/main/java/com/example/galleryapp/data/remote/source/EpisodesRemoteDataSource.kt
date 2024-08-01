package com.example.galleryapp.data.remote.source

import com.example.galleryapp.data.model.EpisodesResponse
import com.example.galleryapp.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow


interface EpisodesRemoteDataSource {
    suspend fun getAllEpisodes(): Flow<DataState<EpisodesResponse>>
    suspend fun getEpisode(episodeId: Int): Flow<DataState<EpisodesResponse>>
}