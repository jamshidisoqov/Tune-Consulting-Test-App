package uz.gita.tune_consulting.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Created by Jamshid Isoqov on 2/7/2023
@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @[Provides Singleton]
    fun provideFireStore(): FirebaseFirestore = FirebaseFirestore.getInstance()

}