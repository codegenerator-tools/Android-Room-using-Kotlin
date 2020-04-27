//Auto Generated using Code Generator
package com.example.database

import androidx.lifecycle.LiveData
import androidx.sqlite.db.SimpleSQLiteQuery

class AccountRepository(private val accountDao: AccountDao) {

    fun getAllData() = accountDao.getAllData()

    fun getAllData(orderBy: String): LiveData<List<Account>> {

        return accountDao.getAllData(orderBy)
    }

	suspend fun insertAll(data: List<Account>): List<Long> {
        return accountDao.insertAll(data);
    }

	suspend fun insert(data: Account): Long {
        return accountDao.insert(data)
    }

    fun getData(whereCondition: String): LiveData<Account> {

        var finalQuery = StringBuilder ();
        finalQuery.append("SELECT * FROM DatabaseConstants.AccountTableKey.TABLE_NAME")

        if(whereCondition.isNotEmpty()) {

            finalQuery.append(" WHERE $whereCondition")
        }

        finalQuery.append(" LIMIT 1")

        val simpleSQLiteQuery = SimpleSQLiteQuery(finalQuery.toString());

        return accountDao.getData(simpleSQLiteQuery)
    }

	fun getListData(whereCondition: String, orderBy: String): LiveData<List<Account>> {

        var finalQuery = StringBuilder ();
        finalQuery.append("SELECT * FROM DatabaseConstants.AccountTableKey.TABLE_NAME")

        if(whereCondition.isNotEmpty()) {

            finalQuery.append(" WHERE $whereCondition")
        }

        if(orderBy.isNotEmpty()) {

            finalQuery.append(" ORDER BY $orderBy")
        }

        val simpleSQLiteQuery = SimpleSQLiteQuery(finalQuery.toString());

        return accountDao.getListData(simpleSQLiteQuery)
    }

    suspend fun delete(whereCondition: String): Int {

        if(whereCondition.isEmpty()) {

            return 0
        }

        var finalQuery = "DELETE FROM DatabaseConstants.AccountTableKey.TABLE_NAME WHERE $whereCondition"
        
        val simpleSQLiteQuery = SimpleSQLiteQuery(finalQuery);

        return accountDao.delete(simpleSQLiteQuery)
    }

    suspend fun deleteAllData(): Int {

        return accountDao.deleteAllData()
    }
}