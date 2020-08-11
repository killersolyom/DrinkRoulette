package drink.roulette.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import drink.roulette.utility.moduleInjector.Module
import drink.roulette.utility.moduleInjector.ModuleInjector

abstract class BaseActivity : AppCompatActivity(), Module {

    private var mIsInstanceStateSaved: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mIsInstanceStateSaved = false
        ModuleInjector().initModules(this)
        injectModules()
        handleIntentEvents(intent)
    }

    abstract fun handleIntentEvents(intent: Intent)

    protected open fun injectModules() {
    }

    override fun onStart() {
        super.onStart()
        mIsInstanceStateSaved = false
    }

    override fun onStop() {
        super.onStop()
        mIsInstanceStateSaved = false
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