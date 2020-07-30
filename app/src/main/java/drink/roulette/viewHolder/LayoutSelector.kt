package drink.roulette.viewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import drink.roulette.R

class LayoutSelector {

    companion object {
        @JvmStatic

        fun getLayoutForItem(parent: ViewGroup, viewType: Int): PlayerNameViewHolder? {
            when (viewType) {
                ViewType.PLAYER_NAME_ITEM.type ->
                    return PlayerNameViewHolder(inflateView(parent, R.layout.player_name_layout))
            }
            return null
        }


        private fun inflateView(parent: ViewGroup, layoutId: Int): View {
            return LayoutInflater.from(parent.context).inflate(layoutId, parent, false);
        }

    }
}