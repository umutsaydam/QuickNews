package com.umutsaydam.quicknewsapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.umutsaydam.quicknewsapp.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConverter {

    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(source: String): Source {
        return source.split(",").let { sourceList ->
            Source(sourceList[0], sourceList[1])
        }
    }
}