package drink.roulette.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import drink.roulette.model.BaseItem
import drink.roulette.viewHolder.BaseViewHolder
import drink.roulette.viewHolder.LayoutSelector
import java.util.*

class ItemAdapter<Item : BaseItem> : RecyclerView.Adapter<BaseViewHolder<Item>>() {

    var mItemList = ArrayList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Item> {
        return LayoutSelector.getLayoutForItem(parent, viewType) as BaseViewHolder<Item>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Item>, position: Int) {
        holder.bindItem(mItemList[position])
    }

    override fun onViewRecycled(holder: BaseViewHolder<Item>) {
        super.onViewRecycled(holder)
        holder.unBindItem()
    }

    override fun getItemViewType(position: Int): Int {
        return mItemList[position].getViewType().type
    }

    override fun getItemCount(): Int {
        return mItemList.size
    }

    fun addItemList(itemList: ArrayList<Item>) {
        this.mItemList = itemList
    }

    fun addItem(item: Item) {
        mItemList.add(item)
        notifyItemInserted(mItemList.indexOf(item))
    }

    fun clearItems() {
        mItemList.clear()
        notifyDataSetChanged()
    }

    val isEmpty: Boolean
        get() = mItemList.isEmpty()

}