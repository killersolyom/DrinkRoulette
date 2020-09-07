package drink.roulette.adapter

import drink.roulette.model.questions.BaseDefaultQuestion

class QuestionAdapter : BaseAdapter<BaseDefaultQuestion>() {

    var mItem: BaseDefaultQuestion? = null

    override fun getItemCount(): Int {
        return if (mItem == null) 0 else 1
    }

    override fun getItem(position: Int): BaseDefaultQuestion? {
        return mItem
    }

    override fun clearItems() {
        mItem = null
    }

    override fun addItem(item: BaseDefaultQuestion) {
        mItem = item
        notifyDataSetChanged()
    }

}