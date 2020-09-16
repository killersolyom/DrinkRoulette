package drink.roulette.activity

import android.content.Intent
import android.view.View
import android.widget.FrameLayout
import drink.roulette.R
import drink.roulette.utility.FragmentNavigation
import drink.roulette.utility.ModuleInjector

class MainActivity : BaseActivity() {

    private val FIRST_START_KEY = "FirstStart"

    lateinit var mLayout: FrameLayout

    lateinit var mNavigator: FragmentNavigation

    override fun handleIntentEvents(intent: Intent) {
        if (!intent.getBooleanExtra(FIRST_START_KEY, false)) {
            mNavigator.showHomeFragment()
            intent.putExtra(FIRST_START_KEY, true)
        }
    }

    override fun injectModules() {
        mNavigator = ModuleInjector.get(FragmentNavigation::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun findView() {
        mLayout = findViewById(R.id.fragment_container)
    }

    override fun getView(): View {
        return mLayout
    }

    override fun onBackPressed() {
        mNavigator.onBackPressed()
    }

}