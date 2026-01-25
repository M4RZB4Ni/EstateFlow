package io.github.m4rzb4ni.data.repository

import io.github.m4rzb4ni.data.dao.PropertyDao
import io.github.m4rzb4ni.data.mapper.toDomain
import io.github.m4rzb4ni.domain.model.Property
import io.github.m4rzb4ni.domain.repository.PropertyRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalPropertyRepository @Inject constructor(private val dao: PropertyDao) :
    PropertyRepository {
    override suspend fun getProperties(): Result<List<Property>> {
        return runCatching {
            val entities = dao.getAllProperties()
            if (entities.isEmpty()) throw Exception("No properties found")
            entities.map { entity -> entity.toDomain() }
        }
    }

    override suspend fun getPropertyById(id: String): Result<Property> {
        return runCatching {
            val entity = dao.getPropertyById(id = id) ?: throw Exception("No Property was found")
            entity.toDomain()
        }
    }
}