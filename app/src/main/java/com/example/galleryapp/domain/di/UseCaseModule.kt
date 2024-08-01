package com.example.galleryapp.domain.di

import com.example.galleryapp.domain.repository.CharacterRepository
import com.example.galleryapp.domain.usecase.characters.GetCharactersFilterUseCase
import com.example.galleryapp.domain.usecase.characters.GetCharactersUseCase
import com.example.galleryapp.domain.usecase.favorite.DeleteFavoriteUseCase
import com.example.galleryapp.domain.usecase.favorite.GetFavoritesUseCase
import com.example.galleryapp.domain.usecase.favorite.UpdateFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @ViewModelScoped
    @Provides
    fun provideGetCharactersUseCase(
        characterRepository: CharacterRepository
    ) = GetCharactersUseCase(characterRepository)

    @ViewModelScoped
    @Provides
    fun provideUpdateFavoriteUseCase(
        characterRepository: CharacterRepository
    ) = UpdateFavoriteUseCase(characterRepository)

    @ViewModelScoped
    @Provides
    fun provideDeleteFavoriteUseCase(
        characterRepository: CharacterRepository
    ) = DeleteFavoriteUseCase(characterRepository)

    @ViewModelScoped
    @Provides
    fun provideGetFavoritesUseCase(
        characterRepository: CharacterRepository
    ) = GetFavoritesUseCase(characterRepository)

    @ViewModelScoped
    @Provides
    fun provideGetCharactersFilterUseCase(
        characterRepository: CharacterRepository
    ) = GetCharactersFilterUseCase(characterRepository)
}