// Author: Khalid Hasan Limon
package com.limon.classwiz.domain.model

sealed class CalculatorMode(val displayName: String) {
    object COMP : CalculatorMode("COMP")
    object CMPLX : CalculatorMode("CMPLX")
    object STAT : CalculatorMode("STAT")
    object BASE_N : CalculatorMode("BASE-N")
    object TABLE : CalculatorMode("TABLE")
    object MATRIX : CalculatorMode("MATRIX")
    object VECTOR : CalculatorMode("VECTOR")
    object EQN : CalculatorMode("EQN")
}
