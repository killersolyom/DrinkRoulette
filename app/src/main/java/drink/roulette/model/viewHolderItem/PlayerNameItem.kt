package drink.roulette.model.viewHolderItem

import drink.roulette.model.BaseItem
import drink.roulette.viewHolder.ViewType
import java.util.*

class PlayerNameItem(private var mName: String) : BaseItem() {


    override fun getViewType(): ViewType {
        return ViewType.PLAYER_NAME_ITEM
    }

    fun getName(): String {
        return mName
    }

    override fun equals(other: Any?): Boolean {
        if (other is PlayerNameItem) {
            return Objects.equals(this.mName, other.getName())
        }

        if (other is String) {
            return Objects.equals(this.mName, other)
        }

        return false
    }
}