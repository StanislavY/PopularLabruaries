package vboyko.gb.libs.lesson1.User

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import vboyko.gb.libs.lesson1.*
import vboyko.gb.libs.lesson1.Settings.UserSettingsFragment
import vboyko.gb.libs.lesson1.Settings.UserSettingsPresenter

//Реализуйте экран пользователя, на котором отобразите его логин.
// Переход на экран осуществите по клику на пользователя в списке через router.navigateTo.

class UsersPresenter(val usersRepo: GithubUsersRepo, val router: Router) : MvpPresenter<UsersView>() {
    val settingsPresenter:UserSettingsPresenter= UserSettingsPresenter(router)
    val screen:IScreens=AndroidScreens()

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()






        override var itemClickListener: ((UserItemView) -> Unit)? = null
        override fun getCount() = users.size
        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->

            val user= usersListPresenter.users[itemView.pos]
            val login=user.login
            settingsPresenter.getLogin(login)
            router.navigateTo(screen.settings())






        }
    }

    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean{
        router.exit()
        return true
    }


}