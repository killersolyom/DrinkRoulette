package drink.roulette.fragment

import android.util.Log
import android.view.View
import butterknife.BindView
import com.szugyi.circlemenu.view.CircleLayout
import drink.roulette.R


class HomeFragment : BaseFragment(), CircleLayout.OnItemClickListener {

    @BindView(R.id.circle_layout)
    lateinit var mCircleMenu: CircleLayout

    override fun onInitializationFinished() {
        mCircleMenu.setOnItemClickListener(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onItemClick(view: View) {
        when (view.id) {
            R.id.home_start -> Log.d(TAG, "start")
            R.id.home_info -> Log.d(TAG, "info")
            R.id.home_settings -> Log.d(TAG, "settings")
            R.id.home_exit -> Log.d(TAG, "exit")
        }
    }

}