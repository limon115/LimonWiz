// Author: Khalid Hasan Limon 🚀
package com.limon.classwiz.core

import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.SharedFlow

interface MviIntent
interface MviState
interface MviEffect

interface MviViewModel<I : MviIntent, S : MviState, E : MviEffect> {
    val state: StateFlow<S>
    val effect: SharedFlow<E>
    fun handleIntent(intent: I)
}