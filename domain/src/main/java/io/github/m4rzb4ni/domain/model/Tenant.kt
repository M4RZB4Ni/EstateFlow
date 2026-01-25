package io.github.m4rzb4ni.domain.model

import java.time.LocalDate

data class Tenant(
    val id: String,
    val fullName: String,
    val email: String,
    val phoneNumber: String?,
    val dateOfBirth: LocalDate?,
    val propertyId: String, // link to Property
    val leaseStartDate: LocalDate?,
    val leaseEndDate: LocalDate?
)
