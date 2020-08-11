package drink.roulette.utility.baseUtils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import drink.roulette.R
import drink.roulette.activity.BaseActivity
import drink.roulette.fragment.BaseFragment
import drink.roulette.fragment.HomeFragment
import drink.roulette.utility.moduleInjector.Module
import kotlin.system.exitProcess


abstract class BaseNavigation(activity: BaseActivity) : Module {

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

    fun onBackPressed() {
        if (shouldPop()) popBackStack() else exit()
    }

    private fun popBackStack() {
        mFragmentManager.popBackStack()
    }

    private fun shouldPop(): Boolean {
        return getTopFragment() !is HomeFragment
    }

    private fun getTopFragment(): BaseFragment? {
        return castToBaseFragment(
            mFragmentManager.fragments.stream()
                .filter { it is BaseFragment && it.isVisible() }?.findFirst()?.orElse(null)
        )
    }

    private fun castToBaseFragment(fragment: Fragment?): BaseFragment? {
        return if (fragment is BaseFragment) fragment else null
    }

    private fun clearBackStack(clearAll: Boolean) {
        val index: Int = if (clearAll) 0 else 1
        for (i in index until mFragmentManager.backStackEntryCount) {
            mFragmentManager.popBackStack()
        }
    }

    fun exit() {
        clearBackStack(true)
        exitProcess(0)
    }

}