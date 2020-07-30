package drink.roulette.viewHolder

import android.view.View
import butterknife.BindView
import drink.roulette.R
import drink.roulette.customView.PlayerNameView
import drink.roulette.model.viewHolderItem.PlayerNameItem

class PlayerNameViewHolder(itemView: View) : BaseViewHolder<PlayerNameItem>(itemView) {


    @BindView(R.id.player_name_view)
    lateinit var mPlayerNameView: PlayerNameView

    override fun bindItem(item: PlayerNameItem) {
        mPlayerNameView.setText(item.getName())
    }

    override fun unBindItem() {

    }

}