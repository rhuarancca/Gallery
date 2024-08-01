package com.example.galleryapp.data.local.db

import android.content.Context
import androidx.compose.runtime.Stable
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.galleryapp.data.local.converter.EpisodeConverter
import com.example.galleryapp.data.local.dao.FavoriteDao
import com.example.galleryapp.data.model.FavoriteEntity
import com.example.galleryapp.data.remote.utils.Constants

@Stable
@Database(
    entities = [FavoriteEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(EpisodeConverter::class)
abstract class GalleryAppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var instance: GalleryAppDatabase? = null

        fun getDatabase(context: Context): GalleryAppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, GalleryAppDatabase::class.java, Constants.TABLE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}