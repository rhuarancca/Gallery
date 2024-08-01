package com.example.galleryapp.domain.usecase.characters

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.galleryapp.data.model.dto.CharacterDto
import com.example.galleryapp.domain.base.BaseUseCase
import com.example.galleryapp.domain.base.IParams
import com.example.galleryapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetCharactersFilterUseCase(
    internal val repository: CharacterRepository
) : BaseUseCase<GetCharactersFilterUseCase.Params, PagingData<CharacterDto>> {

    data class Params(
        val pagingConfig: PagingConfig,
        val options: Map<String, String>
    ) : IParams

    override suspend fun invoke(param: Params): Flow<PagingData<CharacterDto>> {
        return Pager(
            config = param.pagingConfig,
            pagingSourceFactory = { CharactersFilterPagingSource(repository, param.options) }
        ).flow
    }
}