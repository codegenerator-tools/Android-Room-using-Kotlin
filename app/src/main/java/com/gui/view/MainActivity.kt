package com.gui.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.database.Account
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.gui.viewadaptor.AccountListAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val newAccountActivityRequestCode = 1
    private lateinit var accountViewModel: AccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = AccountListAdapter(this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Get a new or existing ViewModel from the ViewModelProvider.
        accountViewModel = ViewModelProvider(this).get(AccountViewModel::class.java)

        // Add an observer on the LiveData
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        accountViewModel.accountList.observe(this, Observer { accounts ->
            // Update the cached copy of the accounts in the adapter.
            accounts?.let { adapter.setAccounts(it) }
        })

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewAccountActivity::class.java)
            startActivityForResult(intent, newAccountActivityRequestCode)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newAccountActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(NewAccountActivity.EXTRA_REPLY)?.let { accountName ->

                insertData(accountName)
            }
        } else {
            Toast.makeText(
                applicationContext,
                "No data receive data",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun insertData(accountName: String) {

        val account = Account(accountName, 10, 0, 0.0, 0.0f)
        accountViewModel.insert(account)

        var kk = accountViewModel.accountList

        print(kk.toString())

        Unit
    }
}
