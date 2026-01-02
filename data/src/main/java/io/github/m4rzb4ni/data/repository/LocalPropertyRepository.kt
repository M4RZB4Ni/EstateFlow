package io.github.m4rzb4ni.data.repository

import io.github.m4rzb4ni.data.dao.PropertyDao
import io.github.m4rzb4ni.domain.enumerations.PropertyType
import io.github.m4rzb4ni.domain.model.Address
import io.github.m4rzb4ni.domain.model.Property
import io.github.m4rzb4ni.domain.repository.PropertyRepository
import javax.inject.Inject

class LocalPropertyRepository @Inject constructor(
    private val dao: PropertyDao

) : PropertyRepository {
    override suspend fun getProperties(): List<Property> {
        return dao.getAllProperties()
            .map { entity ->
                Property(
                    id = entity.id,
                    name = entity.name,
                    address = Address(entity.address, "", "", "", ""),
                    type = PropertyType.valueOf(entity.type),
                    sizeInSqm = entity.sizeInSqm,
                    numberOfRooms = entity.numberOfRooms,
                )
            }
    }
}