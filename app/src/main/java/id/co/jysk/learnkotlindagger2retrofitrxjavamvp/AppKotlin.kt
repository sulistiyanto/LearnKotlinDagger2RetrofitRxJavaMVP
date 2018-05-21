package id.co.jysk.learnkotlindagger2retrofitrxjavamvp

import android.app.Application
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.di.AppComponent
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.di.AppModule
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.di.DaggerAppComponent

class AppKotlin: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .build()
    }
}