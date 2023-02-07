package uz.gita.tune_consulting.data.firebase

import kotlinx.coroutines.flow.Flow
import uz.gita.tune_consulting.data.models.reponse.CardResponse
import uz.gita.tune_consulting.data.models.request.CardRequest
import uz.gita.tune_consulting.utils.ResultData

// Created by Jamshid Isoqov on 2/7/2023
interface CardHelper {

    fun getAllCards(): Flow<ResultData<List<CardResponse>>>

    fun addCard(cardRequest: CardRequest): Flow<ResultData<CardResponse>>

}