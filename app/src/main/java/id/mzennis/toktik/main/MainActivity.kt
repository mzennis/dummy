package id.mzennis.toktik.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.mzennis.toktik.MyApplication
import id.mzennis.toktik.R
import id.mzennis.toktik.main.di.DaggerMainComponent
import id.mzennis.toktik.main.di.MainComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainComponent: MainComponent
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainComponent = DaggerMainComponent.builder()
            .applicationComponent((application as MyApplication).appComponent)
            .build()

        setContentView(R.layout.activity_main)
    }
}