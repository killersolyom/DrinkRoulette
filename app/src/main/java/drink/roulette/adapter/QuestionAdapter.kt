package drink.roulette.adapter

import drink.roulette.model.DefaultItem

class QuestionAdapter : BaseAdapter<DefaultItem>() {

    var mItem: DefaultItem? = null

    override fun getItemCount(): Int {
        return if (mItem == null) 0 else 1
    }

    override fun getItem(position: Int): DefaultItem? {
        return mItem
    }

    override fun clearItems() {
        mItem = null
    }

    override fun addItem(item: DefaultItem) {
        mItem = item
        notifyDataSetChanged()
    }

}