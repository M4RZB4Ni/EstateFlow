package io.github.m4rzb4ni.domain.model

import java.time.LocalDate

data class Lease(
    val id: String,
    val propertyId: String,
    val tenantId: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val rentAmount: Float
)
