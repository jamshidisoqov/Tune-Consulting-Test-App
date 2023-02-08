package uz.gita.tune_consulting.presentation.ui.cards.page

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.tune_consulting.R
import uz.gita.tune_consulting.data.models.reponse.CardResponse
import uz.gita.tune_consulting.databinding.ListItemCardsBinding
import uz.gita.tune_consulting.utils.extensions.combine
import uz.gita.tune_consulting.utils.extensions.include
import uz.gita.tune_consulting.utils.extensions.inflate
import uz.gita.tune_consulting.utils.extensions.toDateFormat

// Created by Jamshid Isoqov on 2/8/2023

private var cardItemCallback = object : DiffUtil.ItemCallback<CardResponse>() {
    override fun areItemsTheSame(oldItem: CardResponse, newItem: CardResponse): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: CardResponse, newItem: CardResponse): Boolean =
        oldItem.id == newItem.id && oldItem.cardNumber == newItem.cardNumber
                && oldItem.cardExpiredDate == newItem.cardExpiredDate

}

class CardsAdapter : ListAdapter<CardResponse, CardsAdapter.ViewHolder>(cardItemCallback) {

    inner class ViewHolder(private val binding: ListItemCardsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() = binding.include {
            val data = getItem(absoluteAdapterPosition)
            tvCardNumber.text = data.cardNumber
            tvCardExpiredDate.text = data.cardExpiredDate.toLong().toDateFormat()
            tvCardBalance.text = (Math.random() * 1000).toString().combine("UZS")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ListItemCardsBinding.bind(parent.inflate(R.layout.list_item_cards)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()

}