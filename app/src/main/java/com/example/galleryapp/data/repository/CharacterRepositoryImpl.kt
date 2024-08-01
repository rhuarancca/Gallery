package com.example.galleryapp.data.repository

import com.example.galleryapp.data.local.dao.FavoriteDao
import com.example.galleryapp.data.model.CharacterInfoResponse
import com.example.galleryapp.data.model.CharacterResponse
import com.example.galleryapp.data.model.FavoriteEntity
import com.example.galleryapp.data.remote.source.CharacterRemoteDataSource
import com.example.galleryapp.data.remote.utils.DataState
import com.example.galleryapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject


class CharacterRepositoryImpl @Inject constructor(
    private val characterRemoteDataSource: CharacterRemoteDataSource,
    private val dao: FavoriteDao
) : CharacterRepository {

    override suspend fun getAllCharacters(
        page: Int,
        options: Map<String, String>
    ): Response<CharacterResponse> =
        characterRemoteDataSource.getAllCharacters(page = page, options = options)

    override fun getCharacter(characterId: Int): Flow<DataState<CharacterInfoResponse>> = flow {
        emitAll(characterRemoteDataSource.getCharacter(characterId = characterId))
    }

    override fun getCharacter(url: String): Flow<DataState<CharacterInfoResponse>> = flow {
        emitAll(characterRemoteDataSource.getCharacter(url = url))
    }

    override suspend fun getFilterCharacters(
        page: Int,
        options: Map<String, String>
    ): Response<CharacterResponse> = characterRemoteDataSource.getFilterCharacters(page, options)

    override suspend fun getFavorite(favoriteId: Int): FavoriteEntity? = dao.getFavorite(favoriteId)

    override suspend fun getFavoriteList(): List<FavoriteEntity> = dao.getFavoriteList()

    override suspend fun deleteFavoriteById(favoriteId: Int) = dao.deleteFavoriteById(favoriteId)

    override suspend fun deleteFavoriteList() = dao.deleteFavoriteList()

    override suspend fun saveFavorite(entity: FavoriteEntity) = dao.insert(entity)

    override suspend fun saveFavoriteList(entityList: List<FavoriteEntity>) = dao.insert(entityList)
}