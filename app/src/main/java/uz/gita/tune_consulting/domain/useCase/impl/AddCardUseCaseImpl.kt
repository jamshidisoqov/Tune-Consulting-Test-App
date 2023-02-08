package uz.gita.tune_consulting.domain.useCase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.tune_consulting.data.models.reponse.CardResponse
import uz.gita.tune_consulting.data.models.request.CardRequest
import uz.gita.tune_consulting.domain.repository.CardRepository
import uz.gita.tune_consulting.domain.useCase.AddCardUseCase
import uz.gita.tune_consulting.utils.ResultData
import javax.inject.Inject

class AddCardUseCaseImpl @Inject constructor(
    private val cardRepository: CardRepository
) : AddCardUseCase {
    override fun addCard(
        cardNumber: String,
        cardExpiredDate: String
    ): Flow<ResultData<CardResponse>> =
        cardRepository.addCard(CardRequest(cardNumber, cardExpiredDate))
}