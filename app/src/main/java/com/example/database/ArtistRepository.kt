//Auto Generated using Code Generator
package com.example.database

import androidx.lifecycle.LiveData
import androidx.sqlite.db.SimpleSQLiteQuery

class ArtistRepository(private val artistDao: ArtistDao) {

    fun getAllData() = artistDao.getAllData()

    fun getAllData(orderBy: String): LiveData<List<Artist>> {

        return artistDao.getAllData(orderBy)
    }

	suspend fun insertAll(data: List<Artist>): List<Long> {
        return artistDao.insertAll(data);
    }

	suspend fun insert(data: Artist): Long {
        return artistDao.insert(data)
    }

    fun getData(whereCondition: String): LiveData<Artist> {

        var finalQuery = StringBuilder ();
        finalQuery.append("SELECT * FROM DatabaseConstants.ArtistTableKey.TABLE_NAME")

        if(whereCondition.isNotEmpty()) {

            finalQuery.append(" WHERE $whereCondition")
        }

        finalQuery.append(" LIMIT 1")

        val simpleSQLiteQuery = SimpleSQLiteQuery(finalQuery.toString());

        return artistDao.getData(simpleSQLiteQuery)
    }

	fun getListData(whereCondition: String, orderBy: String): LiveData<List<Artist>> {

        var finalQuery = StringBuilder ();
        finalQuery.append("SELECT * FROM DatabaseConstants.ArtistTableKey.TABLE_NAME")

        if(whereCondition.isNotEmpty()) {

            finalQuery.append(" WHERE $whereCondition")
        }

        if(orderBy.isNotEmpty()) {

            finalQuery.append(" ORDER BY $orderBy")
        }

        val simpleSQLiteQuery = SimpleSQLiteQuery(finalQuery.toString());

        return artistDao.getListData(simpleSQLiteQuery)
    }

    suspend fun delete(whereCondition: String): Int {

        if(whereCondition.isEmpty()) {

            return 0
        }

        var finalQuery = "DELETE FROM DatabaseConstants.ArtistTableKey.TABLE_NAME WHERE $whereCondition"
        
        val simpleSQLiteQuery = SimpleSQLiteQuery(finalQuery);

        return artistDao.delete(simpleSQLiteQuery)
    }

    suspend fun deleteAllData(): Int {

        return artistDao.deleteAllData()
    }
}