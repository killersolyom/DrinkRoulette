package drink.roulette.adapter

import android.view.View
import drink.roulette.model.DefaultItem
import drink.roulette.utility.FragmentNavigation
import drink.roulette.utility.ModuleInjector

class QuestionAdapter : ItemAdapter<DefaultItem>() {

    private lateinit var mNavigator: FragmentNavigation

    private val mCLickListener = View.OnClickListener { onNext() }

    init {
        injectModules()
    }

    private fun injectModules() {
        mNavigator = ModuleInjector.get(FragmentNavigation::class.java)
    }

    fun getClickListener(): View.OnClickListener {
        return mCLickListener
    }

    private fun onNext() {
        if (mItemList.size == 1) {
            mNavigator.showHomeFragment()
        } else {
            notifyDataSetChanged()
            mItemList.removeAt(0)
        }
    }

}