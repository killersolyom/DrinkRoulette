package drink.roulette.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import drink.roulette.listener.EventListener
import drink.roulette.model.event.Event
import drink.roulette.utility.FragmentNavigation
import drink.roulette.utility.moduleInjector.InjectModule
import drink.roulette.utility.moduleInjector.ModuleInjector

abstract class BaseFragment : Fragment(), EventListener {

    val TAG = this.javaClass.canonicalName

    private lateinit var mView: View

    @InjectModule
    lateinit var mNavigator: FragmentNavigation

    override fun onCreateView(inflanter: LayoutInflater, container: ViewGroup?, b: Bundle?): View? {
        if (view == null) {
            mView = inflanter.inflate(getLayoutId(), container, false)
        }
        initComponents()
        ButterKnife.bind(this, mView)
        ModuleInjector.inject(this)
        return mView
    }

    protected abstract fun getLayoutId(): Int

    protected open fun initComponents() {}

    protected abstract fun onInitializationFinished()

    protected open fun removeCallbacks() {}

    override fun onEvent(event: Event?): Boolean {
        return false
    }

    override fun onResume() {
        super.onResume()
        onInitializationFinished()
    }

    override fun onPause() {
        super.onPause()
        removeCallbacks()
    }
}