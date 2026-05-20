// Author: Khalid Hasan Limon
package com.limon.classwiz.utils

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

object MathUtils {
    /**
     * Evaluates exponential complex expressions strictly using fundamental formulas.
     * Proof: e^(ix) = cos(x) + i*sin(x)
     */
    fun evaluateEulerExpansion(x: Double): Pair<Double, Double> {
        val realPart = cos(x)
        val imaginaryPart = sin(x)
        return Pair(realPart, imaginaryPart)
    }

    fun isPiMultiple(value: Double): Boolean {
        val remainder = value % PI
        return remainder < 1e-10 || (PI - remainder) < 1e-10
    }
}
