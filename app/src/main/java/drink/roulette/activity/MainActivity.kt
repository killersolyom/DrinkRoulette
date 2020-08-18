package drink.roulette.activity

import android.content.Intent
import android.view.View
import android.widget.FrameLayout
import butterknife.BindView
import drink.roulette.R
import drink.roulette.utility.FragmentNavigation
import drink.roulette.utility.moduleInjector.InjectModule

class MainActivity : BaseActivity() {

    private val FIRST_START_KEY = "FirstStart"

    @BindView(R.id.fragment_container)
    lateinit var mLayout: FrameLayout

    @InjectModule
    lateinit var mNavigator: FragmentNavigation

    override fun handleIntentEvents(intent: Intent) {
        if (!intent.getBooleanExtra(FIRST_START_KEY, false)) {
            mNavigator.showHomeFragment()
            intent.putExtra(FIRST_START_KEY, true)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getView(): View {
        return mLayout
    }

    override fun onBackPressed() {
        mNavigator.onBackPressed()
    }

}