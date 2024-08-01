package com.example.galleryapp.data.remote.api

import com.example.galleryapp.data.model.EpisodesResponse
import com.example.galleryapp.data.remote.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodesService {

    @GET(Constants.EPISODE_LIST)
    suspend fun getAllEpisodes(): Response<EpisodesResponse>

    @GET(Constants.GET_EPISODE)
    suspend fun getEpisode(
        @Path(Constants.PARAM_ID) episodeId: Int
    ): Response<EpisodesResponse>

}