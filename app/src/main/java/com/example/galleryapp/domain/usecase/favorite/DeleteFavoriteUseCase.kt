package com.example.galleryapp.domain.usecase.favorite

import com.example.galleryapp.domain.base.BaseUseCase
import com.example.galleryapp.domain.base.IParams
import com.example.galleryapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class DeleteFavoriteUseCase(
    internal val repository: CharacterRepository
) : BaseUseCase<DeleteFavoriteUseCase.Params, Unit> {

    data class Params(
        val characterId: Int?
    ) : IParams

    override suspend fun invoke(param: Params): Flow<Unit> {
        param.characterId?.let {
            repository.deleteFavoriteById(param.characterId)
        } ?: kotlin.run {
            repository.deleteFavoriteList()
        }
        return flow { emit(Unit) }
    }
}