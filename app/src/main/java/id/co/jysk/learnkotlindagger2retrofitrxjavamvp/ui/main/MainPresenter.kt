package id.co.jysk.learnkotlindagger2retrofitrxjavamvp.ui.main

import android.util.Log
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.base.BasePresenter
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.data.repo.ValueRepository
import javax.inject.Inject

class MainPresenter @Inject constructor(val repo: ValueRepository): BasePresenter<MainView>() {

    fun daftar(npm: String, nama: String, kelas: String) {
        disposables.add(repo.daftar(npm, nama, kelas,
                response = {
                    it.let {
                        val a = it.message
                        view?.messageString(a)
                        view?.test()
                        Log.d("success kook", it.message)
                    }
                },
                error = {
                    it.message?.let { it1 -> view?.messageString(it1) }
                    Log.d("error", it.printStackTrace().toString())
                }
        ))
    }
}