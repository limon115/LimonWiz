// Author: Khalid Hasan Limon 🚀
package com.limon.classwiz.domain.model

/**
 * Core AST representation of mathematical textbook input.
 * Strictly decouples UI visualization from Symja evaluation syntax.
 */
sealed class MathToken {
    data class Number(val value: String) : MathToken()
    data class Operator(val op: String) : MathToken()
    data class Fraction(val numerator: List<MathToken>, val denominator: List<MathToken>) : MathToken()
    data class Root(val degree: List<MathToken>?, val radicand: List<MathToken>) : MathToken()
    data class Power(val base: List<MathToken>, val exponent: List<MathToken>) : MathToken()
    data class Function(val name: String, val args: List<MathToken>) : MathToken()
}

data class CursorState(
    val path: List<Int> = emptyList(), // Represents depth in AST, e.g., inside a fraction denominator
    val position: Int = 0 // Position within the current token list
)