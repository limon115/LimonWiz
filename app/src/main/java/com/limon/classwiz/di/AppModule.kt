// Author: Khalid Hasan Limon
package com.limon.classwiz.di

import com.limon.classwiz.domain.engine.CursorEngine
import com.limon.classwiz.domain.engine.InputSystem
import com.limon.classwiz.domain.engine.SymjaAdapter
import com.limon.classwiz.presentation.viewmodel.CalculatorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { CursorEngine() }
    single { SymjaAdapter() }
    single { InputSystem() }
    viewModel { CalculatorViewModel(get(), get()) }
}
