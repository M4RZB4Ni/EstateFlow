package io.github.m4rzb4ni.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "properties")
data class PropertyEntity(
    @PrimaryKey val id: String,
    val name: String,
    @Embedded val address: AddressEntity,
    val type: String,
    val sizeInSqm: Float,
    val numberOfRooms: Int,
    val createdAt: LocalDate?,
    val updatedAt: LocalDate?
)
