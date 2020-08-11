package drink.roulette.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import butterknife.ButterKnife


abstract class BaseViewHolder<GenericItem> internal constructor(itemView: View) :
    ViewHolder(itemView) {

    private var mItemView: View

    private fun findView(itemView: View) {
        ButterKnife.bind(this, itemView)
    }

    abstract fun bindItem(genericItem: GenericItem)

    abstract fun unBindItem()

    protected fun onItemClicked(genericItem: GenericItem) {}

    init {
        findView(itemView)
        mItemView = itemView
    }
}