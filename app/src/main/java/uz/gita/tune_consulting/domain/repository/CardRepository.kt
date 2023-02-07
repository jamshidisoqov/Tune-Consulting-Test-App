package uz.gita.tune_consulting.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.tune_consulting.data.models.reponse.CardResponse
import uz.gita.tune_consulting.data.models.request.CardRequest
import uz.gita.tune_consulting.utils.ResultData

// Created by Jamshid Isoqov on 2/7/2023
interface CardRepository {

    fun getAllCards(): Flow<ResultData<List<CardResponse>>>

    fun addCard(cardRequest: CardRequest): Flow<ResultData<CardResponse>>

    fun isAlreadyAddedCard(cardRequest: CardRequest): Flow<ResultData<Unit>>

}