package com.ilya.mihailenko.eventreminder.model.data.database.event

import com.ilya.mihailenko.eventreminder.common.alarm.AlarmType
import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.utils.ext.toDateTime
import com.ilya.mihailenko.eventreminder.utils.ext.toTimestamp
import com.ilya.mihailenko.eventreminder.utils.mapper.BaseTwoWayMapper
import com.ilya.mihailenko.eventreminder.utils.mapper.Mapper
import dagger.Reusable
import javax.inject.Inject

@Reusable
class EventDtoMapper @Inject constructor() : BaseTwoWayMapper<EventDto, Event>() {

    override fun createMapperTo(): Mapper<EventDto, Event> = Mapper {
        with(it) {
            Event(
                id = id,
                name = name,
                description = description,
                reminderDate = reminderDate.toDateTime(),
                createdAt = createdAt.toDateTime(),
                isRepeated = isRepeated,
                alarmType = AlarmType.valueOf(alarmType)
            )
        }
    }

    override fun createMapperFrom(): Mapper<Event, EventDto> = Mapper {
        with(it) {
            EventDto(
                name = name,
                description = description,
                reminderDate = reminderDate.toTimestamp(),
                createdAt = createdAt.toTimestamp(),
                isRepeated = isRepeated,
                alarmType = alarmType.name
            )
        }
    }
}