package drink.roulette.fragment

import android.view.View
import android.widget.TextView
import butterknife.BindView
import drink.roulette.R
import drink.roulette.adapter.ItemAdapter
import drink.roulette.customView.ParchmentView
import drink.roulette.model.viewHolderItem.PlayerNameItem


class PlayerInputFragment : BaseFragment() {

    private lateinit var mItemAdapter: ItemAdapter<PlayerNameItem>

    @BindView(R.id.names_recycler_view)
    lateinit var mPlayerRecyclerView: ParchmentView<PlayerNameItem>

    @BindView(R.id.description_text)
    lateinit var mDescriptionText: TextView

    @BindView(R.id.add_player_button)
    lateinit var mAddButton: View

    override fun getLayoutId(): Int {
        return R.layout.fragment_player_input
    }

    override fun initComponents() {
        mItemAdapter = ItemAdapter()
    }

    override fun onInitializationFinished() {
        mPlayerRecyclerView.setAdapter(mItemAdapter)
        mAddButton.setOnClickListener { mItemAdapter.addItem(PlayerNameItem("Player")) }
    }


}