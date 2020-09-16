package drink.roulette.fragment

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.szugyi.circlemenu.view.CircleLayout
import drink.roulette.R


class HomeFragment : BaseFragment(), CircleLayout.OnItemClickListener {

    lateinit var mCircleMenu: CircleLayout
    lateinit var mFirstImage: ImageView
    lateinit var mSecondImage: ImageView

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun findView(view: View) {
        mCircleMenu = view.findViewById(R.id.circle_layout)
        mFirstImage = view.findViewById(R.id.bottle_image_1)
        mSecondImage = view.findViewById(R.id.bottle_image_2)
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
            R.id.home_start -> mNavigator.showPlayerInputFragment()
            R.id.home_info -> mNavigator.showMoreFragment()
            R.id.home_settings -> mNavigator.showSettingsFragment()
            R.id.home_exit -> mNavigator.exit()
        }
    }

    override fun removeCallbacks() {
        Glide.with(this).clear(mFirstImage)
        Glide.with(this).clear(mSecondImage)
    }

}