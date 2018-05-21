package id.co.jysk.learnkotlindagger2retrofitrxjavamvp.ui.main

import android.content.Intent
import android.util.Log
import android.widget.Toast
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.AppKotlin
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.R
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.base.BaseActivity
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.data.model.HaloEvent
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.di.subcomponent.MainActivityComponent
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.ui.another.SecondActivity
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.util.MySharedPreferences

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject



class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var sharedPreferences: MySharedPreferences
    @Inject
    lateinit var presenter: MainPresenter

    override fun initInjection() {
        val activityComponent: MainActivityComponent = (applicationContext as AppKotlin)
                .appComponent
                .activityComponent()
                .build()

        activityComponent.inject(this)
    }

    override fun initLayout() {
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        presenter.attach(this)

        sharedPreferences.putData("newUser", 10)
        Log.d("jajal 2", "${sharedPreferences.getData("newUser")} pp")

        buttonDaftar.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
            EventBus.getDefault().postSticky(HaloEvent("test uhui"))
//            EventBus.getDefault().post(sharedPreferences.getData("newUser"))
//            presenter.daftar(
//                editTextNPM.text.toString(),
//                editTextNama.text.toString(),
//                editTextKelas.text.toString())
        }
    }

    override fun messageString(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        Log.d("messageooo", message.capitalize())
    }

    override fun test() {
        Log.d("jajal 2", "${sharedPreferences.getData("newUser")} pp")
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun onMessageEvent(event: HaloEvent) {
        Log.d("test0", event.teks)
    }
}
