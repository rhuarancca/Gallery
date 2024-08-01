package com.example.galleryapp.domain.usecase.favorite

import com.example.galleryapp.data.model.dto.CharacterDto
import com.example.galleryapp.data.model.dto.extension.toFavoriteEntity
import com.example.galleryapp.domain.base.BaseUseCase
import com.example.galleryapp.domain.base.IParams
import com.example.galleryapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.flow

class UpdateFavoriteUseCase(
    internal val repository: CharacterRepository
) : BaseUseCase<UpdateFavoriteUseCase.Params, Unit> {

    data class Params(
        val character: CharacterDto
    ) : IParams

    override suspend fun invoke(param: Params) = flow<Unit> {
        val dto = param.character
        val character = repository.getFavorite(dto.id ?: 0)
        if (character == null) {
            repository.saveFavorite(dto.toFavoriteEntity())
        } else {
            repository.deleteFavoriteById(dto.id ?: 0)
        }
        emit(Unit)
    }
}