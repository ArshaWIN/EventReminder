package com.ilya.mihailenko.eventreminder.model.data.database

import android.arch.persistence.room.TypeConverter
import java.util.*


object Converters {

    @TypeConverter
    @JvmStatic
    fun convertDateFrom(value: Date?): Long? = value?.time

    @TypeConverter
    @JvmStatic
    fun convertDateTo(value: Long?): Date? = value?.let(::Date)
}