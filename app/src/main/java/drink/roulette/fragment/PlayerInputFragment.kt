package drink.roulette.fragment

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import drink.roulette.R
import drink.roulette.adapter.ItemAdapter
import drink.roulette.model.viewHolderItem.PlayerNameItem


class PlayerInputFragment : BaseFragment() {

    @BindView(R.id.names_recycler_view)
    lateinit var mPlayerRecyclerView: RecyclerView

    @BindView(R.id.description_text)
    lateinit var mDescriptionText: TextView

    @BindView(R.id.add_player_button)
    lateinit var mAddButton: View

    private lateinit var mItemAdapter: ItemAdapter<PlayerNameItem>

    override fun getLayoutId(): Int {
        return R.layout.fragment_player_input
    }

    override fun onInitializationFinished() {
        mItemAdapter = ItemAdapter()
        mPlayerRecyclerView.adapter = mItemAdapter
        mPlayerRecyclerView.layoutManager = GridLayoutManager(context, 1)
        mAddButton.setOnClickListener { mItemAdapter.addItem(PlayerNameItem("Player")) }
    }


}