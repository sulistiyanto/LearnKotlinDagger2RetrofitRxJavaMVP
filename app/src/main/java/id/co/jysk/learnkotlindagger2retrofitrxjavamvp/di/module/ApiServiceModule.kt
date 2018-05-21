package id.co.jysk.learnkotlindagger2retrofitrxjavamvp.di.module

import dagger.Module
import dagger.Provides
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.data.ApiServiceInsert
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiServiceModule {

    @Provides
    @Singleton
    fun providesApiServiceInsert(retrofit: Retrofit): ApiServiceInsert {
        return retrofit.create(ApiServiceInsert::class.java)
    }
}