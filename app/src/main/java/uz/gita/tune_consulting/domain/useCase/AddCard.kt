package uz.gita.tune_consulting.domain.useCase

import kotlinx.coroutines.flow.Flow
import uz.gita.tune_consulting.data.models.reponse.CardResponse
import uz.gita.tune_consulting.utils.ResultData

// Created by Jamshid Isoqov on 2/7/2023
interface AddCard {

    fun addCard(cardNumber: String, cardExpiredDate: String): Flow<ResultData<CardResponse>>

}