package com.ilya.mihailenko.eventreminder.model.data.database.event

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.ilya.mihailenko.eventreminder.model.data.database.BaseDao
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface EventDao : BaseDao<EventDto> {

    @Query("SELECT * FROM ${EventDto.TABLE_NAME}")
    fun observeData(): Flowable<List<EventDto>>

    @Query("SELECT * FROM ${EventDto.TABLE_NAME}")
    fun getData(): Single<List<EventDto>>
}