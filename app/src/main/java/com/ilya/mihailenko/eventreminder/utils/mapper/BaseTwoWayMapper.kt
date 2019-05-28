package com.ilya.mihailenko.eventreminder.utils.mapper

abstract class BaseTwoWayMapper<Src, Dst> protected constructor() : TwoWayMapper<Src, Dst> {

    private val mapperTo: Mapper<Src, Dst> by lazy { createMapperTo() }
    private val mapperFrom: Mapper<Dst, Src> by lazy { createMapperFrom() }

    override fun mapperTo(): Mapper<Src, Dst> = mapperTo
    override fun mapperFrom(): Mapper<Dst, Src> = mapperFrom

    protected abstract fun createMapperTo(): Mapper<Src, Dst>
    protected abstract fun createMapperFrom(): Mapper<Dst, Src>
}