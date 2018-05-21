package id.co.jysk.learnkotlindagger2retrofitrxjavamvp.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    internal fun provideSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences("PrefName", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = context
}
