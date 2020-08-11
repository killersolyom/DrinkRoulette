package drink.roulette.fragment

import android.view.View
import android.widget.ImageView
import butterknife.BindView
import com.bumptech.glide.Glide
import com.szugyi.circlemenu.view.CircleLayout
import drink.roulette.R
import drink.roulette.utility.FragmentNavigation
import drink.roulette.utility.moduleInjector.ModuleInjector


class HomeFragment : BaseFragment(), CircleLayout.OnItemClickListener {

    @BindView(R.id.circle_layout)
    lateinit var mCircleMenu: CircleLayout

    @BindView(R.id.bottle_image_1)
    lateinit var mFirstImage: ImageView

    @BindView(R.id.bottle_image_2)
    lateinit var mSecondImage: ImageView

    private val mNavigator: FragmentNavigation? =
        ModuleInjector.getModule(FragmentNavigation::class.java)

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onInitializationFinished() {
        // Set listeners
        mCircleMenu.setOnItemClickListener(this)
        mFirstImage.setOnClickListener {}
        mSecondImage.setOnClickListener {}

        // Load images
        Glide.with(this).load(R.drawable.martini).into(mFirstImage)
        Glide.with(this).load(R.drawable.vodka).into(mSecondImage)
    }

    override fun onItemClick(view: View) {
        when (view.id) {
            R.id.home_start -> mNavigator?.showPlayerInputFragment()
            R.id.home_info -> mNavigator?.showMoreFragment()
            R.id.home_settings -> mNavigator?.showSettingsFragment()
            R.id.home_exit -> mNavigator?.exit()
        }
    }

    override fun removeCallbacks() {
        Glide.with(this).clear(mFirstImage)
        Glide.with(this).clear(mSecondImage)
    }

}