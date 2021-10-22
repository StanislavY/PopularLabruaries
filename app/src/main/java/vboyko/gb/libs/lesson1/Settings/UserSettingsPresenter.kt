package vboyko.gb.libs.lesson1.Settings

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import vboyko.gb.libs.lesson1.IScreens
import vboyko.gb.libs.lesson1.MainView
import vboyko.gb.libs.lesson1.SettingsView

class UserSettingsPresenter(val routerUserSettings:Router):MvpPresenter<SettingsView>() {


    fun getLogin(text:String){
        Login.LOGIN=text


    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initSettings(Login.LOGIN)





        }
    }


