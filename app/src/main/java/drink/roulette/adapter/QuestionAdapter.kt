package drink.roulette.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import drink.roulette.model.questions.BaseDefaultQuestion
import drink.roulette.viewHolder.BaseViewHolder
import drink.roulette.viewHolder.LayoutSelector

class QuestionAdapter : RecyclerView.Adapter<BaseViewHolder<BaseDefaultQuestion>>() {

    var mItem: BaseDefaultQuestion? = null

    override fun onCreateViewHolder(p: ViewGroup, vT: Int): BaseViewHolder<BaseDefaultQuestion> {
        return LayoutSelector.getLayoutForItem(p, vT) as BaseViewHolder<BaseDefaultQuestion>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BaseDefaultQuestion>, position: Int) {
        mItem?.let { holder.bindItem(it) }
    }

    override fun onViewRecycled(holder: BaseViewHolder<BaseDefaultQuestion>) {
        super.onViewRecycled(holder)
        holder.unBindItem()
    }

    override fun getItemViewType(position: Int): Int {
        return mItem?.getViewType()?.type ?: -1
    }

    override fun getItemCount(): Int {
        return if (mItem == null) 0 else 1
    }

    fun addQuestion(item: BaseDefaultQuestion) {
        mItem = item
    }

}