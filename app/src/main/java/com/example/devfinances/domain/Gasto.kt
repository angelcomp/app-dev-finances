package com.example.devfinances.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gasto_table")
data class Gasto(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val descricao: String,
    val valor: Double,
    val data: String,
    val ganhou: Boolean)