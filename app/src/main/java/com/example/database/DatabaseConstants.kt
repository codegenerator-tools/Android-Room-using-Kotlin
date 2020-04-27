//Auto Generated using Code Generator

package com.example.database;

class  DatabaseConstants {

	interface BaseConstants {
        companion object {

			// If you change the database schema, you must increment the database version
		const val DATABASE_VERSION = 1
			const val DATABASE_NAME = "database.db"
		}
	}

	interface AccountTableKey {

		companion object {

			const val TABLE_NAME = "account"

			const val ACCOUNT_ID_FIELD = "account_id"
			const val NAME_FIELD = "name"
			const val AGE_FIELD = "age"
			const val DATE_FIELD = "date"
			const val EARNINGS_FIELD = "earnings"
			const val MORE_FIELD = "more"
        }
    }

	interface ArtistTableKey {

		companion object {

			const val TABLE_NAME = "artist"

			const val ARTIST_ID_FIELD = "artist_id"
			const val ACCCT_FIELD = "accct"
			const val AGE_FIELD = "age"
			const val ACT_ID_FIELD = "act_id"
        }
    }

}
