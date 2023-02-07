package uz.gita.tune_consulting.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.tune_consulting.data.firebase.CardHelper
import uz.gita.tune_consulting.data.firebase.impl.CardHelperImpl
import javax.inject.Singleton

// Created by Jamshid Isoqov on 2/7/2023
@Module
@InstallIn(SingletonComponent::class)
interface FirebaseHelperModule {

    @[Binds Singleton]
    fun bindCardHelper(impl:CardHelperImpl):CardHelper
}