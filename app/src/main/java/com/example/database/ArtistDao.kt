//Auto Generated using Code Generator
package com.example.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery

@Dao
interface ArtistDao: BaseCommonDao<Artist> {

    @Query("SELECT * FROM ${DatabaseConstants.ArtistTableKey.TABLE_NAME}")
	fun getAllData(): LiveData<List<Artist>>

    @Query("SELECT * FROM ${DatabaseConstants.ArtistTableKey.TABLE_NAME} ORDER BY :orderBy") 
	fun getAllData(orderBy: String): LiveData<List<Artist>>

    @RawQuery(observedEntities = [Artist::class])
    fun getData(query: SupportSQLiteQuery?): LiveData<Artist>

    @RawQuery(observedEntities = [Artist::class])
    fun getListData(query: SupportSQLiteQuery?): LiveData<List<Artist>>

    @Query("DELETE FROM ${DatabaseConstants.ArtistTableKey.TABLE_NAME}")
    suspend fun deleteAllData(): Int

    @RawQuery(observedEntities = [Artist::class])
    suspend fun delete(query: SupportSQLiteQuery?): Int

    /**
     * Table name to be utilized by BaseCommonDao to perform operations sa. execution of
     * Sqlite functions (MAX, MIN, etc..)
     */
    override fun getTableName(): String {
        return DatabaseConstants.ArtistTableKey.TABLE_NAME
    }
}