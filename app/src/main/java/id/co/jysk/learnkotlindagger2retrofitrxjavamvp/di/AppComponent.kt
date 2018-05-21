package id.co.jysk.learnkotlindagger2retrofitrxjavamvp.di

import dagger.Component
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.di.module.ApiServiceModule
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.di.module.NetworkModule
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.di.subcomponent.MainActivityComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    ApiServiceModule::class])
interface AppComponent {
    fun activityComponent(): MainActivityComponent.Builder
}