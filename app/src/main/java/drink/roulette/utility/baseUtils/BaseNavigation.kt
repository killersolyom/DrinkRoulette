package drink.roulette.utility.baseUtils

import androidx.fragment.app.FragmentManager
import drink.roulette.R
import drink.roulette.activity.BaseActivity
import drink.roulette.fragment.BaseFragment
import drink.roulette.fragment.HomeFragment
import kotlin.system.exitProcess


abstract class BaseNavigation(activity: BaseActivity) {

    private var mFragmentManager: FragmentManager = activity.supportFragmentManager
    private var mActivity = activity

    internal fun showFragment(fragment: BaseFragment) {
        if (!mActivity.isInstanceStateSaved()) {
            mFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.TAG)
                .addToBackStack(fragment.TAG)
                .commit()
        }
    }

    private fun getTopFragment(): BaseFragment? {
        mFragmentManager.fragments.forEach { if (it is BaseFragment && it.isVisible) return it }
        return null
    }

    private fun popBackStack() {
        mFragmentManager.popBackStack()
    }

    private fun clearBackStack(clearAll: Boolean) {
        for (i in (if (clearAll) 0 else 1) until mFragmentManager.backStackEntryCount) {
            mFragmentManager.popBackStack()
        }
    }

    fun onBackPressed() {
        if (shouldExit()) exit() else popBackStack()
    }

    private fun shouldExit(): Boolean {
        return getTopFragment() is HomeFragment
    }

    fun exit() {
        clearBackStack(true)
        exitProcess(0)
    }

}