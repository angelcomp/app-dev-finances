package com.example.devfinances.database

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.devfinances.domain.Gasto

@Dao
interface GastoDAO {
    @Insert
    suspend fun insert(gasto: Gasto)

    @Query("DELETE FROM gasto_table WHERE id = :id")
    suspend fun delete(id: String)

    @Query("SELECT * FROM gasto_table")
    suspend fun getAll(): List<Gasto>
}