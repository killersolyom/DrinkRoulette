package drink.roulette.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseViewHolder<GenericItem> internal constructor(view: View) : ViewHolder(view) {

    init {
        findView(view)
    }

    protected var mItemView: View = view

    protected abstract fun findView(view: View)

    abstract fun bindItem(item: GenericItem)

    abstract fun unBindItem()

}