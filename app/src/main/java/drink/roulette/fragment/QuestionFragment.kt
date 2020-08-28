package drink.roulette.fragment

import android.os.Bundle
import android.view.View
import drink.roulette.R
import drink.roulette.model.viewHolderItem.PlayerNameItem
import java.util.*

class QuestionFragment : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_question
    }

    override fun findView(view: View) {

    }

    override fun onInitializationFinished() {

    }

    companion object {
        private val PLAYER_LIST: String = "PLAYER_LIST"

        @JvmStatic
        fun newInstance(players: ArrayList<PlayerNameItem>): BaseFragment {
            return QuestionFragment().apply {
                arguments = Bundle().apply { putSerializable(PLAYER_LIST, players) }
            }
        }
    }


}