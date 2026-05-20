// Author: Khalid Hasan Limon
package com.limon.classwiz

import android.app.Application
import com.limon.classwiz.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CalculatorApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CalculatorApplication)
            modules(appModule)
        }
    }
}
