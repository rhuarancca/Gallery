package com.example.galleryapp.data.di

import androidx.compose.runtime.Stable
import com.example.galleryapp.data.local.dao.FavoriteDao
import com.example.galleryapp.data.remote.api.CharacterService
import com.example.galleryapp.data.remote.source.CharacterRemoteDataSource
import com.example.galleryapp.data.remote.source.impl.CharacterRemoteDataSourceImpl
import com.example.galleryapp.data.repository.CharacterRepositoryImpl
import com.example.galleryapp.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit


@Stable
@Module
@InstallIn(ViewModelComponent::class)
class CharacterModule {
    @Provides
    fun provideCharacterService(retrofit: Retrofit): CharacterService =
        retrofit.create(CharacterService::class.java)

    @Provides
    fun provideCharacterRemoteDataSource(
        characterService: CharacterService,
        dao: FavoriteDao
    ): CharacterRemoteDataSource =
        CharacterRemoteDataSourceImpl(characterService, dao)

    @Provides
    fun provideCharacterRepository(
        accountRemoteDataSource: CharacterRemoteDataSource,
        dao: FavoriteDao
    ): CharacterRepository =
        CharacterRepositoryImpl(accountRemoteDataSource, dao)
}