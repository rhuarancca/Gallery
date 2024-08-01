package com.example.galleryapp.data.local.converter

import androidx.compose.runtime.Stable
import androidx.room.TypeConverter
import com.example.galleryapp.utils.Utility.fromJson
import com.example.galleryapp.utils.Utility.toJson

@Stable
class EpisodeConverter {
    @TypeConverter
    fun toListOfStrings(stringValue: String): List<String>? {
        return stringValue.fromJson()
    }

    @TypeConverter
    fun fromListOfStrings(listOfString: List<String>?): String {
        return listOfString.toJson()
    }
}

