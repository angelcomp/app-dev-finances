package com.example.devfinances.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.devfinances.models.Gasto

@Dao
interface GastoDao {

    @Query("SELECT * FROM gasto")
    fun todaLista(): LiveData<List<Gasto> >

    @Query("SELECT * FROM gasto where id LIKE :id")
    suspend fun  encontrarItem(id: Int): Gasto

    @Query("SELECT COUNT(*) from gasto")
    suspend fun contarTodos(): Int

    @Insert
    suspend fun inserir(vararg gasto: Gasto)

    @Delete
    suspend fun deletar(gasto: Gasto)
}