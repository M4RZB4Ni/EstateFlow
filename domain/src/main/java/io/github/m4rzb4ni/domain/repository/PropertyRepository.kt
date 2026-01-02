package io.github.m4rzb4ni.domain.repository

import io.github.m4rzb4ni.domain.model.Property

interface PropertyRepository {
    suspend fun getProperties(): List<Property>
}