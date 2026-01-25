package io.github.m4rzb4ni.domain.model
import io.github.m4rzb4ni.domain.enumerations.PropertyType
import java.time.LocalDate

data class Property(
    val id: String,
    val name: String,
    val address: Address,
    val type: PropertyType,
    val sizeInSqm: Float,
    val numberOfRooms: Int,
    val tenants: List<Tenant> = emptyList(), // optional, can link tenants
    val createdAt: LocalDate? = null,
    val updatedAt: LocalDate? = null
)
