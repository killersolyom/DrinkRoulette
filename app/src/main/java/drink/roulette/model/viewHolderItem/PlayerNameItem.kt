package drink.roulette.model.viewHolderItem

import drink.roulette.model.BaseItem
import drink.roulette.viewHolder.ViewType

class PlayerNameItem(private var mName: String) : BaseItem() {


    override fun getViewType(): ViewType {
        return ViewType.PLAYER_NAME_ITEM
    }

    fun getName(): String {
        return mName
    }

}