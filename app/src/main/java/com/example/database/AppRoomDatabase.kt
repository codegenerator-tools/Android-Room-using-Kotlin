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

/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.  In a real
 * app, consider exporting the schema to help you with migrations.
 */
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
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
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