package drink.roulette.utility

import drink.roulette.activity.BaseActivity
import drink.roulette.fragment.*
import drink.roulette.model.viewHolderItem.PlayerNameItem
import drink.roulette.utility.baseUtils.BaseNavigation


class FragmentNavigation(activity: BaseActivity) : BaseNavigation(activity) {

    fun showHomeFragment() {
        showFragment(HomeFragment())
    }

    fun showQuestionFragment(playerList: ArrayList<PlayerNameItem>) {
        showFragment(QuestionFragment.newInstance(playerList))
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

    override fun beforeFragmentLoaded(newFragment: BaseFragment) {
        when (newFragment.javaClass) {
            QuestionFragment::class.java, QuestionFragment::class.java -> clearBackStack(true)
        }
    }

    override fun shouldExit(): Boolean {
        val topFragment = getTopFragment() ?: return true
        return when (topFragment.javaClass) {
            HomeFragment::class.java, QuestionFragment::class.java -> true
            else -> false
        }
    }

}