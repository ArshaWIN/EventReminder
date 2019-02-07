package com.ilya.mihailenko.eventreminder.model.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.ilya.mihailenko.eventreminder.entity.Event
import io.reactivex.Flowable

@Dao
interface EventDao : BaseDao<Event> {

    @Query("SELECT * FROM ${Event.TABLE_NAME}")
    fun getData(): Flowable<List<Event>>
}