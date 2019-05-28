package com.ilya.mihailenko.eventreminder.model.data.database.event

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = EventDto.TABLE_NAME)
data class EventDto(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val description: String,
    val reminderDate: Long,
    val createdAt: Long
) {
    companion object {
        const val TABLE_NAME = "reminder"
    }
}