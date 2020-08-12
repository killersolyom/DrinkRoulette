package drink.roulette.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import drink.roulette.utility.DataManager
import drink.roulette.utility.FragmentNavigation
import drink.roulette.utility.QuestionManager
import drink.roulette.utility.moduleInjector.ModuleInjector

abstract class BaseActivity : AppCompatActivity() {

    private var mIsInstanceStateSaved: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mIsInstanceStateSaved = false
        ModuleInjector().initModules(getModules())
        ModuleInjector.inject(this)
        handleIntentEvents(intent)
    }

    private fun getModules(): Array<Any> {
        return arrayOf(
            this,
            FragmentNavigation(this),
            DataManager(this),
            QuestionManager(this)
        )
    }

    abstract fun handleIntentEvents(intent: Intent)

    override fun onStart() {
        super.onStart()
        mIsInstanceStateSaved = false
    }

    override fun onStop() {
        super.onStop()
        mIsInstanceStateSaved = false
    }

    override fun onDestroy() {
        super.onDestroy()
        ModuleInjector().destroy()
    }

    override fun onResume() {
        super.onResume()
        mIsInstanceStateSaved = false
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        mIsInstanceStateSaved = true
    }

    fun isInstanceStateSaved(): Boolean {
        return mIsInstanceStateSaved
    }

}