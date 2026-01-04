package io.github.m4rzb4ni.data.dao

import androidx.room.Dao
import androidx.room.Query
import io.github.m4rzb4ni.data.database.BaseDao
import io.github.m4rzb4ni.data.entity.PropertyEntity

@Dao
interface PropertyDao : BaseDao<PropertyEntity> {
    @Query("SELECT * FROM properties")
    suspend fun getAllProperties(): List<PropertyEntity>

    @Query("SELECT * FROM properties WHERE id = :id LIMIT 1")
    suspend fun getPropertyById(id: String): PropertyEntity?
}