package com.meray.aihelloworld.domain
import kotlin.math.exp
class ColorNeuron {
    private val wR = -0.34f
    private val wG = -0.5f
    private val wB = -0.44f
    private val bias = 0.3f

    fun predict(r: Int, g: Int, b: Int) : Float{
        val rN = r / 255f
        val gN = g / 255f
        val bN = b / 255f


        val z = (rN * wR) + (gN * wG) + (bN * wB) + bias
        return sigmoid(z)
    }

    private fun sigmoid(z: Float) : Float = 1.0f / (1.0f + exp(-z))
}