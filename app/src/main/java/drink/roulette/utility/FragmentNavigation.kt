package drink.roulette.utility

import androidx.fragment.app.FragmentManager
import drink.roulette.R
import drink.roulette.activity.MainActivity
import drink.roulette.fragment.BaseFragment
import drink.roulette.fragment.HomeFragment


class FragmentNavigation {
    companion object {

        private var mFragmentManager: FragmentManager? = null

        @JvmStatic
        fun initialize(activity: MainActivity?) {
            mFragmentManager = activity?.supportFragmentManager
        }

        fun showHomeFragment() {
            showFragment(HomeFragment())
        }

        private fun showFragment(fragment: BaseFragment) {
            mFragmentManager!!
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.TAG)
                .addToBackStack(fragment.TAG)
                .commit()
        }


    }
}