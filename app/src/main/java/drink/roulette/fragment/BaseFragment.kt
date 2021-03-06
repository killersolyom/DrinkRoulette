package drink.roulette.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import drink.roulette.utility.FragmentNavigation
import drink.roulette.utility.ModuleInjector

abstract class BaseFragment : Fragment() {

    val TAG = this.javaClass.canonicalName

    protected lateinit var mNavigator: FragmentNavigation

    private lateinit var mView: View

    override fun onCreateView(inflanter: LayoutInflater, container: ViewGroup?, b: Bundle?): View? {
        if (view == null) {
            mView = inflanter.inflate(getLayoutId(), container, false)
        }
        findView(mView)
        injectModules()
        arguments?.let { loadArguments(it) }
        initComponents()
        return mView
    }

    protected abstract fun getLayoutId(): Int

    protected open fun initComponents() {}

    protected abstract fun findView(view: View)

    @CallSuper
    protected open fun injectModules() {
        mNavigator = ModuleInjector.get(FragmentNavigation::class.java)
    }

    protected open fun loadArguments(bundle: Bundle) {
    }

    protected open fun onInitializationFinished() {}

    protected open fun removeCallbacks() {}

    override fun onResume() {
        super.onResume()
        onInitializationFinished()
    }

    override fun onPause() {
        super.onPause()
        removeCallbacks()
    }
}