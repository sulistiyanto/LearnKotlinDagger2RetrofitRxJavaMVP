package id.co.jysk.learnkotlindagger2retrofitrxjavamvp.ui.another

import android.util.Log
import android.widget.Toast
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.R
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.base.BaseActivity
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.data.model.HaloEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class SecondActivity : BaseActivity() {

    override fun initInjection() {
    }

    override fun initLayout() {
        setContentView(R.layout.activity_second)
    }


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: HaloEvent) {
        Toast.makeText(this, "Menerima ${event.teks}", Toast.LENGTH_SHORT).show()
        Log.d("testp", event.teks)
    }

}
