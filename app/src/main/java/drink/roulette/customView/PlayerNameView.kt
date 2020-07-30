package drink.roulette.customView

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import butterknife.BindView
import drink.roulette.R
import drink.roulette.model.viewHolderItem.PlayerNameItem

class PlayerNameView(context: Context, attrs: AttributeSet?) :
    BaseCustomView<PlayerNameItem>(context, attrs) {

    @BindView(R.id.player_name_text)
    lateinit var mItemText: TextView

    override fun getLayoutId(): Int {
        return R.layout.player_names_view
    }

    override fun onInitializationFinished() {

    }

    fun setText(text: String) {
        mItemText.text = text
    }


}