package drink.roulette.model

import drink.roulette.viewHolder.ViewType

abstract class BaseItem {
    abstract fun getViewType(): ViewType
}