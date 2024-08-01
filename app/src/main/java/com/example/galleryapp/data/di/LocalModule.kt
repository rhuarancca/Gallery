package com.example.galleryapp.data.di

import android.content.Context
import androidx.compose.runtime.Stable
import androidx.room.Room
import com.example.galleryapp.data.local.dao.FavoriteDao
import com.example.galleryapp.data.local.db.GalleryAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Stable
@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun provideRickAndMortyDatabase(
        @ApplicationContext context: Context
    ): GalleryAppDatabase {
        return GalleryAppDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideFavoriteDao(appDatabase: GalleryAppDatabase): FavoriteDao {
        return appDatabase.favoriteDao()
    }
}