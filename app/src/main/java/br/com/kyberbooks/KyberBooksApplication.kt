package br.com.kyberbooks

import android.app.Application
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KyberBooksApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}