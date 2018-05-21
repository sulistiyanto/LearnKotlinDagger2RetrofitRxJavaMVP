package id.co.jysk.learnkotlindagger2retrofitrxjavamvp.data.repo

import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.data.ApiServiceInsert
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.data.model.ValueResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ValueRepository @Inject constructor(val apiService: ApiServiceInsert) {

    fun daftar(npm: String, nama: String, kelas: String,
               response: (ValueResponse) -> Unit, error: (Throwable) -> Unit): Disposable =
            apiService.daftar(npm, nama, kelas)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(
                        {
                            response(it)
                        },
                        {error(it)}
                )

}