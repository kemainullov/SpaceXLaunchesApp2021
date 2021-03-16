package com.kamil.ainullov.cache.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.kamil.ainullov.cache.db.model.LaunchModel

@Dao
interface LaunchDao: BaseDao<LaunchModel> {

    @Query("SELECT * FROM launch WHERE id = :id")
    suspend fun getLaunch(id: String): LaunchModel

    @Query("DELETE FROM launch")
    suspend fun deleteAll()
}