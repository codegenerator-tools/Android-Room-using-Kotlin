//Auto Generated using Code Generator
package com.example.database

import android.database.Cursor
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.RawQuery
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery

/**
 * Class holds the common functionality for all the DAO classes
 * s.a. insert, update, delete and sqlite functions
 */
interface BaseCommonDao<T> {

    /**
     * Sqlite functions
     */
    interface SqliteFunctions {
        companion object {
            const val AVERAGE = "avg"
            const val COUNT = "count"
            const val MAX = "max"
            const val MIN = "min"
            const val SUM = "sum"
            const val TOTAL = "total"
        }
    }

    /**
     * Forced to be implemented by all its child classes
     * It will be utilized for Sqlite function execution
     *
     * @return the table name
     */
    abstract fun getTableName(): String

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(data: List<T>): List<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(data: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun update(data: T): Long

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateAll(data: List<T>): List<Long>

    @Delete
    suspend fun delete(obj: T): Int

    @RawQuery
    fun executeSqliteFunction(query: SupportSQLiteQuery?): Cursor

    /**
     * To perform the execution of Sqlite functions
     * s.a avg, count, max, min, sum, total, ..
     *
     * e.g function("max", "id", null);
     * will return the maximum value of 'id' column
     *
     * Returns the sqlite function response of the given [functionType] = BaseCommonDao.SqliteFunctions.MAX, BaseCommonDao.SqliteFunctions.MIN, etc..,
     * [columnName] or [condition], if any.
     */
    fun function(
        functionType: String, columnName: String,
        condition: String?
    ): Long {
        var result: Long = 0
        var cursor: Cursor?
        var rawQuery = (" select " + functionType + "(" + columnName
                + ")" + " from " + getTableName())
        if (condition != null && condition.isNotEmpty()) rawQuery += " where $condition"

        val simpleSQLiteQuery = SimpleSQLiteQuery(rawQuery.toString());
        cursor = executeSqliteFunction(simpleSQLiteQuery)

        if (cursor.moveToFirst()) {
            result = cursor.getLong(0)
            cursor.close()
        }

        return result
    }
}