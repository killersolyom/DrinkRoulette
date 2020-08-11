package drink.roulette.activity

import android.content.Intent
import android.os.Bundle
import drink.roulette.R
import drink.roulette.utility.FragmentNavigation
import drink.roulette.utility.moduleInjector.InjectModule

class MainActivity : BaseActivity() {

    private val FIRST_START_KEY = "FirstStart"

    @InjectModule(FragmentNavigation::class)
    lateinit var mNavigator: FragmentNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun handleIntentEvents(intent: Intent) {
        if (!intent.getBooleanExtra(FIRST_START_KEY, false)) {
            mNavigator.showHomeFragment()
            intent.putExtra(FIRST_START_KEY, true)
        }
    }

    override fun onBackPressed() {
        mNavigator.onBackPressed()
    }

}