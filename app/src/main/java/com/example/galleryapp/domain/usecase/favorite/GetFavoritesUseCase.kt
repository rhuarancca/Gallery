package com.example.galleryapp.domain.usecase.favorite

import com.example.galleryapp.data.model.dto.CharacterDto
import com.example.galleryapp.data.model.dto.extension.toFavoriteDtoList
import com.example.galleryapp.domain.base.BaseUseCase
import com.example.galleryapp.domain.base.IParams
import com.example.galleryapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.flow

class GetFavoritesUseCase(
    internal val repository: CharacterRepository
) : BaseUseCase<IParams, List<CharacterDto>> {

    override suspend fun invoke(param: IParams) = flow {
        val favorites = repository.getFavoriteList()
        emit(favorites.toFavoriteDtoList())
    }
}