package drink.roulette.customView

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import drink.roulette.R
import drink.roulette.model.viewHolderItem.PlayerNameItem

class PlayerNameView(context: Context, attrs: AttributeSet?) :
    BaseCustomView<PlayerNameItem>(context, attrs) {

    lateinit var mItemText: TextView

    override fun getLayoutId(): Int {
        return R.layout.player_names_view
    }

    override fun findView(view: View) {
        mItemText = view.findViewById(R.id.player_name_text)
    }

    override fun onInitializationFinished() {}

    fun setText(text: String) {
        mItemText.text = text
    }

    public override fun onDestroy() {
        mItemText.text = null
    }

}