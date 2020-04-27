package com.gui.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.database.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AccountViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: AccountRepository
    private val accountDao: AccountDao = AppRoomDatabase.getDatabase(application, viewModelScope).accountDao()

    // LiveData is used to get the latest updates from the database
    val accountList: LiveData<List<Account>>

    init {

        //initialize the database
        repository = AccountRepository(accountDao)
        accountList = repository.getAllData(DatabaseConstants.AccountTableKey.ACCOUNT_ID_FIELD)
    }

    fun insert(account: Account) = viewModelScope.launch {
        repository.insert(account)
    }


//    val max: Long = accountDao.function(BaseCommonDao.SqliteFunctions.MAX, DatabaseConstants.AccountTableKey.ACCOUNT_ID_FIELD,"")
}
