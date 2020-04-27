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
interface AccountDao: BaseCommonDao<Account> {

    @Query("SELECT * FROM ${DatabaseConstants.AccountTableKey.TABLE_NAME}")
	fun getAllData(): LiveData<List<Account>>

    @Query("SELECT * FROM ${DatabaseConstants.AccountTableKey.TABLE_NAME} ORDER BY :orderBy") 
	fun getAllData(orderBy: String): LiveData<List<Account>>

    @RawQuery(observedEntities = [Account::class])
    fun getData(query: SupportSQLiteQuery?): LiveData<Account>

    @RawQuery(observedEntities = [Account::class])
    fun getListData(query: SupportSQLiteQuery?): LiveData<List<Account>>

    @Query("DELETE FROM ${DatabaseConstants.AccountTableKey.TABLE_NAME}")
    suspend fun deleteAllData(): Int

    @RawQuery(observedEntities = [Account::class])
    suspend fun delete(query: SupportSQLiteQuery?): Int

    /**
     * Table name to be utilized by BaseCommonDao to perform operations sa. execution of
     * Sqlite functions (MAX, MIN, etc..)
     */
    override fun getTableName(): String {
        return DatabaseConstants.AccountTableKey.TABLE_NAME
    }
}