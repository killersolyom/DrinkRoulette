package drink.roulette.utility

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import drink.roulette.R
import drink.roulette.activity.MainActivity
import drink.roulette.fragment.*
import kotlin.system.exitProcess


class FragmentNavigation {
    companion object {

        private lateinit var mFragmentManager: FragmentManager

        @JvmStatic
        fun initialize(activity: MainActivity?) {
            mFragmentManager = activity!!.supportFragmentManager
        }

        fun showHomeFragment() {
            showFragment(HomeFragment())
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

        private fun showFragment(fragment: BaseFragment) {
            mFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.TAG)
                .addToBackStack(fragment.TAG)
                .commit()
        }

        fun onBackPressed() {
            if (shouldPop()) {
                popBackStack()
            } else {
                exit()
            }
        }

        private fun popBackStack() {
            mFragmentManager.popBackStack()
        }

        private fun shouldPop(): Boolean {
            val fragment: BaseFragment? = getTopFragment()
            return fragment !is HomeFragment
        }

        private fun getTopFragment(): BaseFragment? {
            return mFragmentManager
                .fragments
                .stream()
                .filter { it is BaseFragment && it.isVisible() }
                ?.findFirst()
                ?.orElse(null)
                ?.let { it1 -> castToBaseFragment(it1) }
        }

        private fun castToBaseFragment(fragment: Fragment): BaseFragment? {
            return if (fragment is BaseFragment) fragment else null
        }

        private fun clearBackStack(clearAll: Boolean) {
            val index: Int = if (clearAll) 0 else 1
            for (i in index until mFragmentManager!!.backStackEntryCount) {
                mFragmentManager.popBackStack()
            }
        }

        fun exit() {
            clearBackStack(true)
            exitProcess(0)
        }

    }
}