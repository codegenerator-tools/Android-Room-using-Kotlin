package com.gui.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

/**
 * Create new account
 */
class NewAccountActivity : AppCompatActivity() {

    private lateinit var accountNameEditText: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_account)
        accountNameEditText = findViewById(R.id.name_edit)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(accountNameEditText.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = accountNameEditText.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.gui.view.NewAccountActivity.REPLY"
    }
}

