package uz.gita.tune_consulting.domain.repository.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.tune_consulting.data.firebase.CardHelper
import uz.gita.tune_consulting.data.models.reponse.CardResponse
import uz.gita.tune_consulting.data.models.request.CardRequest
import uz.gita.tune_consulting.domain.repository.CardRepository
import uz.gita.tune_consulting.utils.ResultData
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardHelper: CardHelper
) : CardRepository {
    override fun getAllCards(): Flow<ResultData<List<CardResponse>>> =
        cardHelper.getAllCards()

    override fun addCard(cardRequest: CardRequest): Flow<ResultData<CardResponse>> =
        cardHelper.addCard(cardRequest)

    override fun isAlreadyAddedCard(cardRequest: CardRequest): Flow<ResultData<Unit>> =
        cardHelper.isAlreadyAddedCard(cardRequest)
}