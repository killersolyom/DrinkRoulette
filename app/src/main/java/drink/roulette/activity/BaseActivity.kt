package drink.roulette.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import drink.roulette.utility.DataManager
import drink.roulette.utility.FragmentNavigation
import drink.roulette.utility.NotificationManager
import drink.roulette.utility.QuestionManager
import drink.roulette.utility.moduleInjector.ModuleInjector

abstract class BaseActivity : AppCompatActivity() {

    private var mIsInstanceStateSaved: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mIsInstanceStateSaved = false
        ButterKnife.bind(this)
        ModuleInjector().initModules(getModules())
        ModuleInjector.inject(this)
        handleIntentEvents(intent)
    }

    private fun getModules(): Array<Any> {
        return arrayOf(
            FragmentNavigation(this),
            DataManager(this),
            QuestionManager(this),
            NotificationManager(this)
        )
    }

    abstract fun handleIntentEvents(intent: Intent)

    protected abstract fun getLayoutId(): Int

    abstract fun getView(): View

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