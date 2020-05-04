package com.example.dkt2

import android.app.Application
import com.example.dkt2.di.component.AppComponent
import com.example.dkt2.di.component.DaggerAppComponent
import com.example.dkt2.di.module.AppModule

class BaseApp : Application(){

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
    }

    private fun initDagger()  = DaggerAppComponent.builder()
        .appModule(AppModule())
        .build()
}