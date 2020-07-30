package drink.roulette.fragment

import android.view.View
import butterknife.BindView
import com.szugyi.circlemenu.view.CircleLayout
import drink.roulette.R
import drink.roulette.utility.FragmentNavigation


class HomeFragment : BaseFragment(), CircleLayout.OnItemClickListener {

    @BindView(R.id.circle_layout)
    lateinit var mCircleMenu: CircleLayout

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onInitializationFinished() {
        mCircleMenu.setOnItemClickListener(this)
    }

    override fun onItemClick(view: View) {
        when (view.id) {
            R.id.home_start -> FragmentNavigation.showPlayerInputFragment()
            R.id.home_info -> FragmentNavigation.showMoreFragment()
            R.id.home_settings -> FragmentNavigation.showSettingsFragment()
            R.id.home_exit -> FragmentNavigation.exit()
        }
    }

}