package com.ilya.mihailenko.eventreminder.model.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.ilya.mihailenko.eventreminder.entity.Event
import io.reactivex.Flowable

@Dao
interface EventDao : BaseDao<EventDao> {

    @Query("SELECT * FROM ${Event.TABLE_NAME}")
    abstract fun getData(): Flowable<List<Event>>
}