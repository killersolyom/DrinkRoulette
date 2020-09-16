package drink.roulette.viewHolder

import android.view.View
import android.widget.TextView
import drink.roulette.R

abstract class BaseChallengeQuestionHolder<Item>(itemView: View) :
    DefaultViewHolder<Item>(itemView) {

    lateinit var mDescriptionView: TextView

    override fun findView(view: View) {
        mDescriptionView = view.findViewById(R.id.item_text_view)
    }

    override fun bindItem(item: Item) {
        mDescriptionView.text = getItemText(item)
    }

    override fun unBindItem() {
        mDescriptionView.text = null
    }

    abstract fun getItemText(item: Item): String

    abstract fun getTitle(): Int

}