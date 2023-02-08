package uz.gita.tune_consulting.presentation.ui.cards.page

import kotlinx.coroutines.flow.StateFlow
import uz.gita.tune_consulting.data.models.reponse.CardResponse
import uz.gita.tune_consulting.utils.extensions.BaseViewModel

// Created by Jamshid Isoqov on 2/8/2023
interface CardPageViewModel : BaseViewModel {

    val allCardsFlow: StateFlow<List<CardResponse>>

    fun getAllCards()

}