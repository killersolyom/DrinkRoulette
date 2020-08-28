package drink.roulette.utility.baseUtils

import androidx.fragment.app.FragmentManager
import drink.roulette.R
import drink.roulette.activity.BaseActivity
import drink.roulette.fragment.BaseFragment
import kotlin.system.exitProcess


abstract class BaseNavigation(activity: BaseActivity) {

    private var mFragmentManager: FragmentManager = activity.supportFragmentManager
    private var mActivity = activity

    protected fun showFragment(fragment: BaseFragment) {
        beforeFragmentLoaded(fragment)
        if (!mActivity.isInstanceStateSaved()) {
            mFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.TAG)
                .addToBackStack(fragment.TAG)
                .commit()
        }
    }

    protected abstract fun beforeFragmentLoaded(newFragment: BaseFragment)

    protected abstract fun shouldExit(): Boolean

    protected fun getTopFragment(): BaseFragment? {
        mFragmentManager.fragments.forEach { if (it is BaseFragment && it.isVisible) return it }
        return null
    }

    protected fun isEmpty(): Boolean {
        return getTopFragment() == null
    }

    private fun popBackStack() {
        mFragmentManager.popBackStack()
    }

    protected fun clearBackStack(clearAll: Boolean) {
        for (i in (if (clearAll) 0 else 1) until mFragmentManager.backStackEntryCount) {
            mFragmentManager.popBackStack()
        }
    }

    fun onBackPressed() {
        if (shouldExit()) exit() else popBackStack()
    }

    fun exit() {
        clearBackStack(true)
        exitProcess(0)
    }

}