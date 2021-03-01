package com.example.devfinances.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "gasto")
class Gasto(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "descricao")
    var descricao: String,

    @ColumnInfo(name = "valor")
    var valor: Double,

    @ColumnInfo(name = "data")
    var data: String,

    @ColumnInfo(name = "gastou")
    var ganhou: Boolean
) {
    override fun toString(): String {
        return "Gasto(descricao='$descricao', valor=$valor, data='$data', ganhou=$ganhou)"
    }
}