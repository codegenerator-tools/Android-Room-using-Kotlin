//Auto Generated using Code Generator
package com.example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import java.sql.Blob

@Entity(
    tableName = (DatabaseConstants.ArtistTableKey.TABLE_NAME),
       foreignKeys = [
           ForeignKey(
               entity = Account::class,
               parentColumns = [DatabaseConstants.AccountTableKey.ACCOUNT_ID_FIELD],
               childColumns = [DatabaseConstants.ArtistTableKey.ACT_ID_FIELD]
               /*onDelete = CASCADE)*/

               )])

data class Artist(
	@ColumnInfo(name = DatabaseConstants.ArtistTableKey.ACCCT_FIELD) val accct: Int,
	@ColumnInfo(name = DatabaseConstants.ArtistTableKey.AGE_FIELD) val age: Int,
	@ColumnInfo(name = DatabaseConstants.ArtistTableKey.ACT_ID_FIELD) val actid: Int

)
{
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = DatabaseConstants.ArtistTableKey.ARTIST_ID_FIELD)	var artistid: Int = 0
}