//Auto Generated using Code Generator
package com.example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import java.sql.Blob

@Entity(
    tableName = (DatabaseConstants.AccountTableKey.TABLE_NAME))

data class Account(

	@ColumnInfo(name = DatabaseConstants.AccountTableKey.NAME_FIELD) val name: String,
	@ColumnInfo(name = DatabaseConstants.AccountTableKey.AGE_FIELD) val age: Int,
	@ColumnInfo(name = DatabaseConstants.AccountTableKey.DATE_FIELD) val date: Long,
	@ColumnInfo(name = DatabaseConstants.AccountTableKey.EARNINGS_FIELD) val earnings: Double,
	@ColumnInfo(name = DatabaseConstants.AccountTableKey.MORE_FIELD) val more: Float

)
{
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = DatabaseConstants.AccountTableKey.ACCOUNT_ID_FIELD)	var accountid: Int = 0
}