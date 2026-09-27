package com.meray.aihelloworld.data.repository

import com.meray.aihelloworld.domain.ColorNeuron
import com.meray.aihelloworld.domain.repository.ColorRepository
import javax.inject.Inject

class ColorRepositoryImpl @Inject constructor(
    private val neuron : ColorNeuron
) : ColorRepository {
    override fun getPrediction(r: Int, g: Int, b: Int): Float = neuron.predict(r,g,b)

}