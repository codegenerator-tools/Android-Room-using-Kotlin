package com.gui.viewadaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.database.Account
import com.gui.view.R

class AccountListAdapter internal constructor(
        context: Context
) : RecyclerView.Adapter<AccountListAdapter.AccountViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    // Cached copy of accounts
    private var accountList = emptyList<Account>()

    inner class AccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val accountItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return AccountViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        val current = accountList[position]
        holder.accountItemView.text = current.name
    }

    internal fun setAccounts(accounts: List<Account>) {
        this.accountList = accounts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return accountList.size
    }

//    override fun getItemCount() = accountList.size
}


