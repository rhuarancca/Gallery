package com.example.galleryapp.data.remote.source

import com.example.galleryapp.data.model.CharacterInfoResponse
import com.example.galleryapp.data.model.CharacterResponse
import com.example.galleryapp.data.model.FavoriteEntity
import com.example.galleryapp.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface CharacterRemoteDataSource {
    suspend fun getAllCharacters(page: Int, options: Map<String, String>): Response<CharacterResponse>
    suspend fun getFilterCharacters(page: Int, options: Map<String, String>): Response<CharacterResponse>
    suspend fun getCharacter(characterId: Int): Flow<DataState<CharacterInfoResponse>>
    suspend fun getCharacter(url: String): Flow<DataState<CharacterInfoResponse>>
    suspend fun getFavoriteList(): List<FavoriteEntity>
    suspend fun getFavorite(favoriteId: Int): FavoriteEntity? = null
    suspend fun deleteFavoriteById(favoriteId: Int): Unit
    suspend fun deleteFavoriteList(): Unit
    suspend fun saveFavorite(entity: FavoriteEntity): Unit
    suspend fun saveFavoriteList(entityList: List<FavoriteEntity>): Unit

}