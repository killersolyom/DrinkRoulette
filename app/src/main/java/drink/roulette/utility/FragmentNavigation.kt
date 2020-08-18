package drink.roulette.utility

import drink.roulette.activity.BaseActivity
import drink.roulette.fragment.HomeFragment
import drink.roulette.fragment.MoreInfoFragment
import drink.roulette.fragment.PlayerInputFragment
import drink.roulette.fragment.SettingsFragment
import drink.roulette.model.viewHolderItem.PlayerNameItem
import drink.roulette.utility.baseUtils.BaseNavigation
import java.util.*


class FragmentNavigation(activity: BaseActivity) : BaseNavigation(activity) {

    fun showHomeFragment() {
        showFragment(HomeFragment())
    }

    fun showQuestionFragment(itemList: ArrayList<PlayerNameItem>) {

    }

    fun showPlayerInputFragment() {
        showFragment(PlayerInputFragment())
    }

    fun showMoreFragment() {
        showFragment(MoreInfoFragment())
    }

    fun showSettingsFragment() {
        showFragment(SettingsFragment())
    }

    override fun shouldExit(): Boolean {
        return getTopFragment() is HomeFragment
    }

}