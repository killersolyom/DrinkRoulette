package drink.roulette.fragment

import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import butterknife.BindView
import drink.roulette.R
import drink.roulette.adapter.ItemAdapter
import drink.roulette.customView.ParchmentView
import drink.roulette.model.viewHolderItem.PlayerNameItem
import drink.roulette.utility.NotificationManager
import drink.roulette.utility.moduleInjector.InjectModule


class PlayerInputFragment : BaseFragment() {

    private lateinit var mItemAdapter: ItemAdapter<PlayerNameItem>

    @InjectModule
    lateinit var mNotificationManager: NotificationManager

    @BindView(R.id.names_recycler_view)
    lateinit var mPlayerRecyclerView: ParchmentView<PlayerNameItem>

    @BindView(R.id.description_text)
    lateinit var mDescriptionText: TextView

    @BindView(R.id.add_player_button)
    lateinit var mAddButton: View

    @BindView(R.id.name_input_view)
    lateinit var mNameInputView: EditText

    @BindView(R.id.done_button)
    lateinit var mDoneButton: View

    override fun getLayoutId(): Int {
        return R.layout.fragment_player_input
    }

    override fun initComponents() {
        mItemAdapter = ItemAdapter()
    }

    override fun onInitializationFinished() {
        mPlayerRecyclerView.setAdapter(mItemAdapter)
        mAddButton.setOnClickListener { onAddButtonClicked() }
        mDoneButton.setOnClickListener { onDoneButtonClicked() }
        mDescriptionText.setText(R.string.name_add_description)
    }

    private fun onDoneButtonClicked() {
        when (mItemAdapter.itemList.size) {
            0 -> mNotificationManager.showToast(R.string.name_list_is_empty, false)
            1 -> mNotificationManager.showToast(R.string.name_list_one_player, false)
            else -> mNavigator.showQuestionFragment(mItemAdapter.itemList)
        }
    }

    private fun onAddButtonClicked() {
        val text = mNameInputView.text

        if (TextUtils.isEmpty(text)) {
            mNotificationManager.showToast(R.string.name_is_empty, false)
            return
        }

        val newName = PlayerNameItem(text.trim().toString())
        if (mItemAdapter.itemList.contains(newName)) {
            mNotificationManager.showToast(R.string.name_already_contains, false)
            return
        }

        mItemAdapter.addItem(newName)

        mNameInputView.text = null
    }

}