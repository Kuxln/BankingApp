package com.kuxln.bankingapp.presentation.services.deposits

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kuxln.bankingapp.data.room.entity.BankAccountEntity
import com.kuxln.bankingapp.data.room.entity.DepositEntity
import com.kuxln.bankingapp.databinding.ListItemCardExpandedBinding
import com.kuxln.bankingapp.databinding.ListItemDepositBinding

class AllDepositsAdapter(
    private var dataSet: List<DepositEntity>,
    private val onLongPress: (selectedDepositId: Int) -> Unit = {},
) : RecyclerView.Adapter<AllDepositsAdapter.DepositViewHolder>() {

    inner class DepositViewHolder(
        private val binding: ListItemDepositBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(depositEntity: DepositEntity) = with(binding) {
            val depositRate = "${14 + (layoutPosition * 2)} %"
            val amount = "${depositEntity.amount} UAH"

            root.setOnLongClickListener {
                onLongPress(depositEntity.depositId)
                true
            }

            binding.tvDepositRate.text = depositRate
            binding.tvDepositAmount.text = amount
        }
    }


    private class CardDiffUtilCallback(
        private val oldDataSet: List<DepositEntity>,
        private val newDataSet: List<DepositEntity>,
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldDataSet.size

        override fun getNewListSize(): Int = newDataSet.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldDataSet[oldItemPosition].depositId == newDataSet[newItemPosition].depositId
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldDataSet[oldItemPosition].depositId == newDataSet[newItemPosition].depositId
        }
    }

    fun updateData(newDataSet: List<DepositEntity>) {
        val diffCallback = CardDiffUtilCallback(dataSet, newDataSet)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        dataSet = newDataSet
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepositViewHolder {
        val binding =
            ListItemDepositBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DepositViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: DepositViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}