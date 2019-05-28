package com.ilya.mihailenko.eventreminder.utils.mapper;

public interface Mapper<T, R> {
    R map(T from);
}
