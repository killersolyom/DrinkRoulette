package drink.roulette.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import drink.roulette.R
import drink.roulette.utility.FragmentNavigation
import drink.roulette.utility.UtilityManager


class MainActivity : AppCompatActivity() {

    private val FIRST_START_KEY = "FirstStart"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        UtilityManager.initUtilities(this)
        handleIntentEvents(intent)
    }

    private fun handleIntentEvents(intent: Intent) {
        if (!intent.getBooleanExtra(FIRST_START_KEY, false)) {
            FragmentNavigation.showHomeFragment()
            intent.putExtra(FIRST_START_KEY, true)
        }
    }

}