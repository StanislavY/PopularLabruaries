package vboyko.gb.libs.lesson1. Settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import vboyko.gb.libs.lesson1.App
import vboyko.gb.libs.lesson1.BackButtonListener
import vboyko.gb.libs.lesson1.SettingsView
import vboyko.gb.libs.lesson1.User.UsersRVAdapter
import vboyko.gb.libs.lesson1.databinding.ActivityMainBinding.inflate
import vboyko.gb.libs.lesson1.databinding.FragmentUsersBinding.inflate
import vboyko.gb.libs.lesson1.databinding.FragmentUsersBinding
import vboyko.gb.libs.lesson1.databinding.UserDetailsFragmentBinding

class UserSettingsFragment :MvpAppCompatFragment(),SettingsView,BackButtonListener{
    companion object{
        fun newInstance()=UserSettingsFragment()
    }

    private var binding:UserDetailsFragmentBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = UserDetailsFragmentBinding.inflate(inflater, container, false).also {
        binding = it
    }.root


    val presenter:UserSettingsPresenter by moxyPresenter{
        UserSettingsPresenter(App.instance.router)}

    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }

    override fun backPressed(): Boolean {
        TODO("Not yet implemented")
    }




    override fun initSettings(text:String) {
        binding?.loginTextView?.text=text
    }


}







/*
    Manager = LinearLayoutManager(context)
            adapter = UsersRVAdapter(presenter.usersListPresenter)
            this.rvUsers.adapter = adapter
        TODO("Not yet implemented")*/



