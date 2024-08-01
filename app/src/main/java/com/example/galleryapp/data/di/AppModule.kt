package com.example.galleryapp.data.di

import android.content.Context
import androidx.compose.runtime.Stable
import com.example.galleryapp.GalleryApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Stable
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): GalleryApp {
        return app as GalleryApp
    }
}