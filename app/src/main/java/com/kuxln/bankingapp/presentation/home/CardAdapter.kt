package com.kuxln.bankingapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.databinding.ListItemCardBinding

class CardAdapter(
    private var dataSet: List<BankAccountEntity>
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    inner class CardViewHolder(
        private val binding: ListItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.tvCardNumber.text = dataSet[position].bankAccountNumber.toString()
            binding.tvCardMoneyQuantity.text = dataSet[position].balance.toString()
            binding.tvExpirationDate.text = "06/2033"
        }
    }

    private class CardDiffUtilCallback(
        private val oldDataSet: List<BankAccountEntity>,
        private val newDataSet: List<BankAccountEntity>,
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldDataSet.size

        override fun getNewListSize(): Int = newDataSet.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldDataSet[oldItemPosition].bankAccountId == newDataSet[newItemPosition].bankAccountId
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldDataSet[oldItemPosition].bankAccountNumber == newDataSet[newItemPosition].bankAccountNumber
        }
    }

    fun updateData(newDataSet: List<BankAccountEntity>) {
        val diffCallback = CardDiffUtilCallback(dataSet, newDataSet)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        dataSet = newDataSet
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ListItemCardBinding.inflate(LayoutInflater.from(parent.context))
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(position)
    }
}