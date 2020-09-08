package drink.roulette.viewHolder

import android.view.View
import drink.roulette.R
import drink.roulette.customView.PlayerNameView
import drink.roulette.model.viewHolderItem.PlayerNameItem

class PlayerNameViewHolder(itemView: View) : DefaultViewHolder<PlayerNameItem>(itemView) {

    lateinit var mPlayerNameView: PlayerNameView

    override fun findView(view: View) {
        mPlayerNameView = view.findViewById(R.id.player_name_view)
    }

    override fun bindItem(item: PlayerNameItem) {
        mPlayerNameView.setText(item.getName())
    }

    override fun unBindItem() {
        mPlayerNameView.onDestroy()
    }

}