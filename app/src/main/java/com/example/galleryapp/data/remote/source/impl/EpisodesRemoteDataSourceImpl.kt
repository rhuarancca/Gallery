package com.example.galleryapp.data.remote.source.impl

import com.example.galleryapp.data.model.EpisodesResponse
import com.example.galleryapp.data.remote.api.EpisodesService
import com.example.galleryapp.data.remote.source.EpisodesRemoteDataSource
import com.example.galleryapp.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodesRemoteDataSourceImpl @Inject constructor(private val episodesService: EpisodesService) :
    BaseRemoteDataSource(), EpisodesRemoteDataSource {

    override suspend fun getAllEpisodes(): Flow<DataState<EpisodesResponse>> = getResult {
        episodesService.getAllEpisodes()
    }

    override suspend fun getEpisode(episodeId: Int): Flow<DataState<EpisodesResponse>> = getResult {
        episodesService.getEpisode(episodeId = episodeId)
    }
}
