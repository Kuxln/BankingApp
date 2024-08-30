package com.kuxln.bankingapp.presentation.home.allcards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.databinding.ListItemCardExpandedBinding

class AllCardsAdapter(
    private var dataSet: List<BankAccountEntity>,
) : RecyclerView.Adapter<AllCardsAdapter.CardExpandedViewHolder>() {

    inner class CardExpandedViewHolder(
        private val binding: ListItemCardExpandedBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val balanceMetadata = "${dataSet[position].balance.toInt()} UAH"
//            val cardBackgroundColor = Color.GREEN
//
//            binding.cardView.setCardBackgroundColor(cardBackgroundColor)
            binding.tvCardNumber.text = dataSet[position].bankAccountNumber.toString()
            binding.tvMoneyQuantity.text = balanceMetadata
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardExpandedViewHolder {
        val binding =
            ListItemCardExpandedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardExpandedViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: CardExpandedViewHolder, position: Int) {
        holder.bind(position)
    }
}