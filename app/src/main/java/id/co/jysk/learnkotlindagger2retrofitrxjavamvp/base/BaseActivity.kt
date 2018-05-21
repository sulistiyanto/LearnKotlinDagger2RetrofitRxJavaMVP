package id.co.jysk.learnkotlindagger2retrofitrxjavamvp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInjection()
        initLayout()
    }

    protected abstract fun initInjection()
    protected abstract fun initLayout()

}