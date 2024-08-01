package com.example.galleryapp.domain.repository

import com.example.galleryapp.data.model.CharacterInfoResponse
import com.example.galleryapp.data.model.CharacterResponse
import com.example.galleryapp.data.model.FavoriteEntity
import com.example.galleryapp.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


interface CharacterRepository {
    suspend fun getAllCharacters(page: Int, options: Map<String, String>): Response<CharacterResponse>
    fun getCharacter(characterId: Int): Flow<DataState<CharacterInfoResponse>>
    fun getCharacter(url: String): Flow<DataState<CharacterInfoResponse>>
    suspend fun getFilterCharacters(page: Int, options: Map<String, String>): Response<CharacterResponse>
    suspend fun getFavoriteList(): List<FavoriteEntity>
    suspend fun getFavorite(favoriteId: Int): FavoriteEntity? = null
    suspend fun deleteFavoriteById(favoriteId: Int): Unit
    suspend fun deleteFavoriteList(): Unit
    suspend fun saveFavorite(entity: FavoriteEntity): Unit
    suspend fun saveFavoriteList(entityList: List<FavoriteEntity>): Unit
}