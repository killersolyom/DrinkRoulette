package drink.roulette.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import drink.roulette.model.BaseItem
import drink.roulette.viewHolder.BaseViewHolder
import drink.roulette.viewHolder.LayoutSelector

abstract class BaseAdapter<Item : BaseItem> : RecyclerView.Adapter<BaseViewHolder<Item>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Item> {
        return LayoutSelector.getLayoutForItem(parent, viewType) as BaseViewHolder<Item>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Item>, position: Int) {
        getItem(position)?.let { holder.bindItem(it) }
    }

    override fun onViewRecycled(holder: BaseViewHolder<Item>) {
        super.onViewRecycled(holder)
        holder.unBindItem()
    }

    override fun getItemViewType(position: Int): Int {
        getItem(position)?.let { return it.getViewType().type }
        return -1
    }

    protected abstract fun getItem(position: Int): Item?

    protected abstract fun clearItems()

    abstract fun addItem(item: Item)

}