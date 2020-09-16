package drink.roulette.utility.baseUtils

import drink.roulette.R
import drink.roulette.activity.BaseActivity
import drink.roulette.fragment.BaseFragment
import drink.roulette.utility.ModuleInjector
import drink.roulette.utility.NotificationManager
import kotlin.system.exitProcess


abstract class BaseNavigation(activity: BaseActivity) {

    private var mActivity: BaseActivity = activity

    private var mNotification: NotificationManager

    private var mLastBackPressTime: Long = 0
    private val mExitTimeLimit: Long = 350

    init {
        mLastBackPressTime = System.currentTimeMillis()
        mNotification = ModuleInjector.get(NotificationManager::class.java)
    }

    protected fun showFragment(fragment: BaseFragment) {
        beforeFragmentLoaded(fragment)
        if (!mActivity.isInstanceStateSaved()) {
            mActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.TAG)
                .addToBackStack(fragment.TAG)
                .commit()
        }
    }

    protected abstract fun beforeFragmentLoaded(newFragment: BaseFragment)

    protected abstract fun shouldExit(): Boolean

    protected abstract fun shouldPop(): Boolean

    protected fun getTopFragment(): BaseFragment? {
        mActivity.supportFragmentManager.fragments.forEach { if (it is BaseFragment && it.isVisible) return it }
        return null
    }

    private fun popBackStack() {
        mActivity.supportFragmentManager.popBackStack()
    }

    protected fun clearBackStack(clearAll: Boolean) {
        for (i in (if (clearAll) 0 else 1) until mActivity.supportFragmentManager.backStackEntryCount) {
            mActivity.supportFragmentManager.popBackStack()
        }
    }

    fun onBackPressed() {
        if (shouldExit()) {
            exit()
            return
        }

        if (shouldPop()) {
            popBackStack()
            return
        }

        mNotification.showToast(R.string.press_again_to_exit)
    }

    protected fun isDoubleBackPressed(): Boolean {
        val currentTime = System.currentTimeMillis()

        if (currentTime - mLastBackPressTime <= mExitTimeLimit) {
            return true
        }

        mLastBackPressTime = currentTime
        return false
    }

    fun exit() {
        clearBackStack(true)
        exitProcess(0)
    }

}