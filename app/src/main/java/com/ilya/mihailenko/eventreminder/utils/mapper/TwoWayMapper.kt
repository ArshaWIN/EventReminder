package com.ilya.mihailenko.eventreminder.utils.mapper

interface TwoWayMapper<Src, Dst> {
    fun mapperTo(): Mapper<Src, Dst>
    fun mapperFrom(): Mapper<Dst, Src>
}