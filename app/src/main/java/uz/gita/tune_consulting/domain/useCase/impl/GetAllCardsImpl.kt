package uz.gita.tune_consulting.domain.useCase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.tune_consulting.data.models.reponse.CardResponse
import uz.gita.tune_consulting.domain.repository.CardRepository
import uz.gita.tune_consulting.domain.useCase.GetAllCards
import uz.gita.tune_consulting.utils.ResultData
import javax.inject.Inject

class GetAllCardsImpl @Inject constructor(
    private val cardRepository: CardRepository
) : GetAllCards {
    override fun getAllCards(): Flow<ResultData<List<CardResponse>>> =
        cardRepository.getAllCards()
}