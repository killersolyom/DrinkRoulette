package drink.roulette.utility

import drink.roulette.activity.BaseActivity
import drink.roulette.fragment.*
import drink.roulette.utility.baseUtils.BaseNavigation


class FragmentNavigation(activity: BaseActivity) : BaseNavigation(activity) {

    fun showHomeFragment() {
        showFragment(HomeFragment())
    }

    fun showQuestionFragment(playerList: ArrayList<String>) {
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
            QuestionFragment::class.java, HomeFragment::class.java -> clearBackStack(true)
        }
    }

    override fun shouldExit(): Boolean {
        val topFragment = getTopFragment() ?: return true
        return when (topFragment.javaClass) {
            HomeFragment::class.java -> true
            QuestionFragment::class.java -> isDoubleBackPressed()
            else -> false
        }
    }

    override fun shouldPop(): Boolean {
        val topFragment = getTopFragment() ?: return true
        return when (topFragment.javaClass) {
            QuestionFragment::class.java -> false
            else -> true
        }
    }
}