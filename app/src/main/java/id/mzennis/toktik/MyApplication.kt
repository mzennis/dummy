package id.mzennis.toktik

import android.app.Application
import id.mzennis.toktik.common.di.ApplicationComponent
import id.mzennis.toktik.common.di.DaggerApplicationComponent

class MyApplication : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.create()
    }
}