package drink.roulette.model

import drink.roulette.viewHolder.ViewType

open class DefaultItem : BaseItem() {
    override fun getViewType(): ViewType {
        return ViewType.DEFAULT_ITEM
    }
}