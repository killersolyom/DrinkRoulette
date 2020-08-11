package drink.roulette.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import drink.roulette.model.BaseItem
import drink.roulette.viewHolder.BaseViewHolder
import drink.roulette.viewHolder.LayoutSelector
import java.util.*

class ItemAdapter<Item : BaseItem> : RecyclerView.Adapter<BaseViewHolder<Item>>() {

    var itemList = ArrayList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Item> {
        return LayoutSelector.getLayoutForItem(parent, viewType) as BaseViewHolder<Item>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Item>, position: Int) {
        holder.bindItem(itemList[position])
    }

    override fun onViewRecycled(holder: BaseViewHolder<Item>) {
        super.onViewRecycled(holder)
        holder.unBindItem()
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].getViewType().type
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun addItemList(itemList: ArrayList<Item>) {
        this.itemList = itemList
    }

    fun addItem(item: Item) {
        itemList.add(item)
        notifyItemInserted(itemList.indexOf(item))
    }

    fun clearItems() {
        itemList.clear()
        notifyDataSetChanged()
    }

    val isEmpty: Boolean
        get() = itemList.isEmpty()

}