package io.github.m4rzb4ni.domain.usecase

import io.github.m4rzb4ni.domain.model.Property
import io.github.m4rzb4ni.domain.repository.PropertyRepository
import javax.inject.Inject


class GetPropertiesUseCase @Inject constructor(
    private val propertyRepository: PropertyRepository
) {
    suspend operator fun invoke(): Result<List<Property>> {
        return propertyRepository.getProperties()
    }
}