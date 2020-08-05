package drink.roulette.customView

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.bumptech.glide.Glide
import drink.roulette.R
import drink.roulette.adapter.ItemAdapter
import drink.roulette.model.BaseItem
import drink.roulette.model.viewHolderItem.PlayerNameItem

class ParchmentView<Item : BaseItem>(context: Context, attrs: AttributeSet?) :
    BaseCustomView<PlayerNameItem>(context, attrs) {

    @BindView(R.id.recycler_view)
    lateinit var mRecyclerView: RecyclerView

    @BindView(R.id.item_background)
    lateinit var mBackground: ImageView

    @BindView(R.id.item_foreground)
    lateinit var mForeground: ImageView

    override fun getLayoutId(): Int {
        return R.layout.parchment_view
    }

    override fun onInitializationFinished() {
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.overScrollMode = View.OVER_SCROLL_NEVER;
        Glide.with(this).load(R.drawable.parchment_background).into(mBackground)
        Glide.with(this).load(R.drawable.parchment_foreground).into(mForeground)
    }

    override fun onDestroy() {
        Glide.with(this).clear(mBackground);
        Glide.with(this).clear(mForeground);
    }

    fun setAdapter(adapter: ItemAdapter<Item>) {
        mRecyclerView.adapter = adapter
    }

}