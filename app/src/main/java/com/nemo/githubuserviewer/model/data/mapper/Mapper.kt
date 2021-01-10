package com.nemo.githubuserviewer.model.data.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}