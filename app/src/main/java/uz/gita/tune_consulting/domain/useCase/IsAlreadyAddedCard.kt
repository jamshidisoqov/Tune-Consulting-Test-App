package uz.gita.tune_consulting.domain.useCase

import kotlinx.coroutines.flow.Flow
import uz.gita.tune_consulting.utils.ResultData

// Created by Jamshid Isoqov on 2/7/2023
interface IsAlreadyAddedCard {
    fun isAlreadyCard(
        cardNumber: String,
        cardExpiredDate: String
    ): Flow<ResultData<Unit>>
}