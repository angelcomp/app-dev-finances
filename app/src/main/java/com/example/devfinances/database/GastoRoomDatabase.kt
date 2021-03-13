package com.example.devfinances.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.devfinances.domain.Gasto

@Database(entities = [Gasto::class], version = 1)
abstract class GastoRoomDatabase : RoomDatabase() {
    abstract fun gastoDao(): GastoDAO

    companion object {

        private var instance: GastoRoomDatabase? = null

        fun getDatabase(context: Context): GastoRoomDatabase {
            if (instance == null) {
                synchronized(GastoRoomDatabase::class.java) {
                    // Criação do DB
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GastoRoomDatabase::class.java,
                        "gasto_database"
                    ).build()
                }
            }
            return instance!!
        }
    }
}