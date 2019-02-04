package com.ilya.mihailenko.eventreminder.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.sql.Date

@Entity(tableName = Event.TABLE_NAME)
data class Event(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val description: String
//    val createdAt: Date
) {
    companion object {
        const val TABLE_NAME = "reminder"
    }
}