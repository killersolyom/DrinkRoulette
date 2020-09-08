package drink.roulette.adapter

import drink.roulette.model.BaseItem
import java.util.*

class ItemAdapter<Item : BaseItem> : BaseAdapter<Item>() {

    var mItemList = ArrayList<Item>()

    fun addItemList(itemList: ArrayList<Item>) {
        this.mItemList = itemList
    }

    override fun addItem(item: Item) {
        mItemList.add(item)
        notifyItemInserted(mItemList.indexOf(item))
    }

    override fun getItem(position: Int): Item {
        return mItemList[position]
    }

    override fun getItemCount(): Int {
        return mItemList.size
    }

    override fun clearItems() {
        mItemList.clear()
        notifyDataSetChanged()
    }

}