package uz.gita.tune_consulting.data.firebase.impl

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import uz.gita.tune_consulting.data.firebase.CARDS_COLLECTION
import uz.gita.tune_consulting.data.firebase.CardHelper
import uz.gita.tune_consulting.data.mapper.toCardResponse
import uz.gita.tune_consulting.data.models.reponse.CardResponse
import uz.gita.tune_consulting.data.models.request.CardRequest
import uz.gita.tune_consulting.utils.ResultData
import javax.inject.Inject

class CardHelperImpl @Inject constructor(
    private val fireStore: FirebaseFirestore
) : CardHelper {
    override fun getAllCards(): Flow<ResultData<List<CardResponse>>> =
        callbackFlow<ResultData<List<CardResponse>>> {
            fireStore.collection(CARDS_COLLECTION)
                .addSnapshotListener { value, error ->
                    if (error == null) {
                        val cards = value?.documents?.map { it.toCardResponse() }
                        trySend(ResultData.Success(cards ?: emptyList()))
                    } else {
                        trySend(ResultData.Error(error))
                    }
                }
        }.catch { error ->
            emit(ResultData.Error(error))
        }.flowOn(Dispatchers.IO)

    override fun addCard(cardRequest: CardRequest): Flow<ResultData<CardResponse>> =
        callbackFlow<ResultData<CardResponse>> {
            fireStore.collection(CARDS_COLLECTION)
                .add(cardRequest)
                .addOnSuccessListener { documentReference ->
                    trySend(ResultData.Success(cardRequest.toCardResponse(documentReference.id)))
                }.addOnFailureListener { e ->
                    trySend(ResultData.Error(e))
                }
        }.catch { error ->
            emit(ResultData.Error(error))
        }.flowOn(Dispatchers.IO)
}