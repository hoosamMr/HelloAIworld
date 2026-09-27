package com.meray.aihelloworld.domain.repository

interface ColorRepository {
    fun getPrediction(r: Int, g: Int, b: Int) : Float
}