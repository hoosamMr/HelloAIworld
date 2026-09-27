package com.meray.aihelloworld.di

import com.meray.aihelloworld.data.repository.ColorRepositoryImpl
import com.meray.aihelloworld.domain.ColorNeuron
import com.meray.aihelloworld.domain.repository.ColorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideColorNeuron() : ColorNeuron = ColorNeuron()

    @Provides
    @Singleton
    fun provideColorRepository(neuron: ColorNeuron): ColorRepository{
        return ColorRepositoryImpl(neuron)
    }
}