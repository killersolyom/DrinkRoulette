package drink.roulette.viewHolder

import android.view.View
import android.widget.TextView
import drink.roulette.R

abstract class QuestionTitleHolder<Item>(itemView: View) :
    BaseChallengeQuestionHolder<Item>(itemView) {

    lateinit var mTitleView: TextView

    override fun findView(view: View) {
        super.findView(view)
        mTitleView = view.findViewById(R.id.item_title_text_view)
    }

    override fun bindItem(item: Item) {
        super.bindItem(item)
        (getTitle() != -1).let { mTitleView.setText(getTitle()) }
    }


}