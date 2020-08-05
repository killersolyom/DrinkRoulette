package drink.roulette.fragment

import android.view.View
import android.widget.ImageView
import butterknife.BindView
import com.bumptech.glide.Glide
import com.szugyi.circlemenu.view.CircleLayout
import drink.roulette.R
import drink.roulette.utility.FragmentNavigation


class HomeFragment : BaseFragment(), CircleLayout.OnItemClickListener {

    @BindView(R.id.circle_layout)
    lateinit var mCircleMenu: CircleLayout

    @BindView(R.id.bottle_image_1)
    lateinit var mMartiniImage: ImageView

    @BindView(R.id.bottle_image_2)
    lateinit var mVodkaImage: ImageView

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onInitializationFinished() {
        mCircleMenu.setOnItemClickListener(this)
        Glide.with(this).load(R.drawable.martini).into(mMartiniImage)
        Glide.with(this).load(R.drawable.vodka).into(mVodkaImage)
    }

    override fun onItemClick(view: View) {
        when (view.id) {
            R.id.home_start -> FragmentNavigation.showPlayerInputFragment()
            R.id.home_info -> FragmentNavigation.showMoreFragment()
            R.id.home_settings -> FragmentNavigation.showSettingsFragment()
            R.id.home_exit -> FragmentNavigation.exit()
        }
    }

    override fun removeCallbacks() {
        Glide.with(this).clear(mMartiniImage)
        Glide.with(this).clear(mVodkaImage)
    }

}