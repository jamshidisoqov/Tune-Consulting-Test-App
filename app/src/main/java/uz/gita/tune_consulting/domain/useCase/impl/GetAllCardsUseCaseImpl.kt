package uz.gita.tune_consulting.domain.useCase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.tune_consulting.data.models.reponse.CardResponse
import uz.gita.tune_consulting.domain.repository.CardRepository
import uz.gita.tune_consulting.domain.useCase.GetAllCardsUseCase
import uz.gita.tune_consulting.utils.ResultData
import javax.inject.Inject

class GetAllCardsUseCaseImpl @Inject constructor(
    private val cardRepository: CardRepository
) : GetAllCardsUseCase {
    override fun getAllCards(): Flow<ResultData<List<CardResponse>>> =
        cardRepository.getAllCards()
}