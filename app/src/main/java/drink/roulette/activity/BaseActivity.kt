package drink.roulette.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import drink.roulette.utility.*

abstract class BaseActivity : AppCompatActivity() {

    private var mIsInstanceStateSaved: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mIsInstanceStateSaved = false
        findView()
        ModuleInjector().initModules(getModules())
        injectModules()
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

    abstract fun findView()

    abstract fun injectModules()

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