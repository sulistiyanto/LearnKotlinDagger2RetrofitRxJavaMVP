package id.co.jysk.learnkotlindagger2retrofitrxjavamvp.ui.main

import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.base.BaseView

interface MainView: BaseView {
    fun messageString(message: String)
}