//Auto Generated using Code Generator
package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Account::class, Artist::class], version = 1, exportSchema = false)
//@TypeConverters(Converters::class)

abstract class AppRoomDatabase : RoomDatabase() {

abstract fun accountDao(): AccountDao
abstract fun artistDao(): ArtistDao

companion object {

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getDatabase(
                context: Context,
                scope: CoroutineScope
        ): AppRoomDatabase {

                return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppRoomDatabase::class.java,
                        "academy"
                )
                                        .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
