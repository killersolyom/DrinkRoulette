package drink.roulette.viewHolder

import android.view.View
import android.widget.TextView
import drink.roulette.R

abstract class BaseChallengeQuestionHolder<Item>(itemView: View) :
    BaseViewHolder<Item>(itemView) {

    lateinit var mDescriptionView: TextView

    override fun findView(view: View) {
        mDescriptionView = view.findViewById(R.id.item_text_view)
    }

    override fun unBindItem() {
        mDescriptionView.text = null
    }

}