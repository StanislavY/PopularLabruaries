package vboyko.gb.libs.lesson1

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import vboyko.gb.libs.lesson1.Settings.UserSettingsFragment
import vboyko.gb.libs.lesson1.User.UsersFragment

class AndroidScreens : IScreens {
    override fun users(): Screen {
        return FragmentScreen { UsersFragment.newInstance() }
    }

    override fun settings(): Screen {
        return FragmentScreen { UserSettingsFragment.newInstance() }
    }
}