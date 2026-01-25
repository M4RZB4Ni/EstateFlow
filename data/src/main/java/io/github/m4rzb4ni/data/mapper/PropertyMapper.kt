package io.github.m4rzb4ni.data.mapper

import io.github.m4rzb4ni.data.entity.PropertyEntity
import io.github.m4rzb4ni.domain.enumerations.PropertyType
import io.github.m4rzb4ni.domain.model.Address
import io.github.m4rzb4ni.domain.model.Property

fun PropertyEntity.toDomain(): Property {
    return Property(
        id = this.id,
        name = this.name,
        address = Address(
            street = address.street,
            city = address.city,
            state = address.state,
            zipCode = address.zipCode,
            country = address.country
        ),
        type = PropertyType.valueOf(this.type),
        sizeInSqm = this.sizeInSqm,
        numberOfRooms = this.numberOfRooms,
    )
}