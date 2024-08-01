package com.example.galleryapp.data.di

import androidx.compose.runtime.Stable
import com.example.galleryapp.data.remote.api.EpisodesService
import com.example.galleryapp.data.remote.source.EpisodesRemoteDataSource
import com.example.galleryapp.data.remote.source.impl.EpisodesRemoteDataSourceImpl
import com.example.galleryapp.data.repository.EpisodesRepositoryImpl
import com.example.galleryapp.domain.repository.EpisodesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Stable
@Module
@InstallIn(ViewModelComponent::class)
class EpisodesModule {
    @Provides
    fun provideEpisodesService(retrofit: Retrofit): EpisodesService =
        retrofit.create(EpisodesService::class.java)

    @Provides
    fun provideEpisodesRemoteDataSource(episodesService: EpisodesService): EpisodesRemoteDataSource =
        EpisodesRemoteDataSourceImpl(episodesService)

    @Provides
    fun provideEpisodesRepository(
        episodesRemoteDataSource: EpisodesRemoteDataSource
    ): EpisodesRepository =
        EpisodesRepositoryImpl(episodesRemoteDataSource)
}