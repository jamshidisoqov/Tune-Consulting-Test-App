package uz.gita.tune_consulting.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.tune_consulting.domain.useCase.AddCardUseCase
import uz.gita.tune_consulting.domain.useCase.GetAllCardsUseCase
import uz.gita.tune_consulting.domain.useCase.IsAlreadyAddedCardUseCase
import uz.gita.tune_consulting.domain.useCase.impl.AddCardUseCaseImpl
import uz.gita.tune_consulting.domain.useCase.impl.GetAllCardsUseCaseImpl
import uz.gita.tune_consulting.domain.useCase.impl.IsAlreadyAddedCardUseCaseImpl

// Created by Jamshid Isoqov on 2/7/2023
@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindAddCard(impl: AddCardUseCaseImpl): AddCardUseCase

    @Binds
    fun bindGetAllCards(impl: GetAllCardsUseCaseImpl): GetAllCardsUseCase

    @Binds
    fun bindIsAlreadyAdded(impl: IsAlreadyAddedCardUseCaseImpl): IsAlreadyAddedCardUseCase

}