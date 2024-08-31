package com.kuxln.bankingapp.presentation.core.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.databinding.ListItemCardExpandedBinding

class AllCardsAdapter(
    private var dataSet: List<BankAccountEntity>,
    private val onClick: (selectedCardId: Int) -> Unit = {},
) : RecyclerView.Adapter<AllCardsAdapter.CardExpandedViewHolder>() {

    inner class CardExpandedViewHolder(
        private val binding: ListItemCardExpandedBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        fun bind(bankAccountEntity: BankAccountEntity) = with(binding) {
            val balanceMetadata = "${bankAccountEntity.balance.toInt()} UAH"
            val cardBackgroundColor = context.getColor(bankAccountEntity.colorId)

            root.setOnClickListener{ onClick(bankAccountEntity.bankAccountId) }

            cardView.setCardBackgroundColor(cardBackgroundColor)
            tvCardNumber.text = bankAccountEntity.bankAccountNumber.toString()
            tvMoneyQuantity.text = balanceMetadata

            tvOnCardCardNumber.text = bankAccountEntity.bankAccountNumber.toString()
            tvOnCardExpirationDate.text = "06/2033"
            tvOnCardMoneyQuantity.text = balanceMetadata
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
        holder.bind(dataSet[position])
    }
}