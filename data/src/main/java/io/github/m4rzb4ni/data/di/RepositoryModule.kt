package io.github.m4rzb4ni.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.m4rzb4ni.data.repository.LocalPropertyRepository
import io.github.m4rzb4ni.domain.repository.PropertyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindPropertyRepository(repository: LocalPropertyRepository): PropertyRepository
}