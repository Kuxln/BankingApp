package com.kuxln.bankingapp.presentation.services.credits

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kuxln.bankingapp.data.room.entity.CreditEntity
import com.kuxln.bankingapp.databinding.ListItemCreditBinding

class AllCreditsAdapter(
    private var dataSet: List<CreditEntity>,
    private val onLongPress: (selectedCreditId: Int) -> Unit = {},
) : RecyclerView.Adapter<AllCreditsAdapter.CreditViewHolder>() {

    inner class CreditViewHolder(
        private val binding: ListItemCreditBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(creditEntity: CreditEntity) = with(binding) {
            val creditRate = "${16 + (layoutPosition * 2)} %"
            val cost = "${creditEntity.cost} UAH"

            root.setOnLongClickListener {
                onLongPress(creditEntity.creditId)
                true
            }

            binding.tvCreditRate.text = creditRate
            binding.tvCreditCost.text = cost
        }
    }


    private class CardDiffUtilCallback(
        private val oldDataSet: List<CreditEntity>,
        private val newDataSet: List<CreditEntity>,
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldDataSet.size

        override fun getNewListSize(): Int = newDataSet.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldDataSet[oldItemPosition].creditId == newDataSet[newItemPosition].creditId
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldDataSet[oldItemPosition].creditId == newDataSet[newItemPosition].creditId
        }
    }

    fun updateData(newDataSet: List<CreditEntity>) {
        val diffCallback = CardDiffUtilCallback(dataSet, newDataSet)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        dataSet = newDataSet
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditViewHolder {
        val binding =
            ListItemCreditBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CreditViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: CreditViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}