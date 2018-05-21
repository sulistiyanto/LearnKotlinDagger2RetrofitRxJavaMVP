package id.co.jysk.learnkotlindagger2retrofitrxjavamvp.di.subcomponent

import dagger.Subcomponent
import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.ui.main.MainActivity

@Subcomponent
interface MainActivityComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): MainActivityComponent
    }
    fun inject(mainActivity: MainActivity)
}