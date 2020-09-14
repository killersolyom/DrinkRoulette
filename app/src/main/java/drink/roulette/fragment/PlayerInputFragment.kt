package drink.roulette.fragment

import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import drink.roulette.R
import drink.roulette.adapter.ItemAdapter
import drink.roulette.customView.ParchmentView
import drink.roulette.model.viewHolderItem.PlayerNameItem
import drink.roulette.utility.ModuleInjector
import drink.roulette.utility.NotificationManager


class PlayerInputFragment : BaseFragment() {

    private lateinit var mNotification: NotificationManager

    private lateinit var mNameAdapter: ItemAdapter<PlayerNameItem>
    private lateinit var mPlayerRecyclerView: ParchmentView<PlayerNameItem>
    private lateinit var mDescriptionText: TextView
    private lateinit var mNameInputView: EditText
    private lateinit var mAddButton: View
    lateinit var mDoneButton: View

    override fun getLayoutId(): Int {
        return R.layout.fragment_player_input
    }

    override fun injectModules() {
        super.injectModules()
        mNotification = ModuleInjector.get(NotificationManager::class.java)
    }

    override fun findView(view: View) {
        mPlayerRecyclerView = view.findViewById(R.id.names_recycler_view)
        mDescriptionText = view.findViewById(R.id.description_text)
        mAddButton = view.findViewById(R.id.add_player_button)
        mNameInputView = view.findViewById(R.id.name_input_view)
        mDoneButton = view.findViewById(R.id.done_button)
    }

    override fun initComponents() {
        mNameAdapter = ItemAdapter()
    }

    override fun onInitializationFinished() {
        mPlayerRecyclerView.setAdapter(mNameAdapter)
        mAddButton.setOnClickListener { onAddButtonClicked() }
        mDoneButton.setOnClickListener { onDoneButtonClicked() }
        mDescriptionText.setText(R.string.name_add_description)
        // TODO remove this
        mNameAdapter.addItem(PlayerNameItem("player1"))
        mNameAdapter.addItem(PlayerNameItem("player2"))
        mNameAdapter.addItem(PlayerNameItem("player3"))
    }

    private fun onDoneButtonClicked() {
        when (mNameAdapter.mItemList.size) {
            0 -> mNotification.showToast(R.string.name_list_is_empty)
            1 -> mNotification.showToast(R.string.name_list_one_player)
            else -> {
                val text = mNameInputView.text.trim().toString()
                if (TextUtils.isEmpty(text)) {
                    mNavigator.showQuestionFragment(getPlayerNames())
                } else {
                    mNotification.showToast(text + getString(R.string.name_not_drinking_player))
                }
            }
        }
    }

    private fun onAddButtonClicked() {
        val text = mNameInputView.text.trim().toString()

        if (TextUtils.isEmpty(text)) {
            mNotification.showToast(R.string.name_is_empty)
            return
        }

        if (mNameAdapter.mItemList.find { item -> item.equals(text) } != null) {
            mNotification.showToast(R.string.name_already_contains)
            return
        }

        mNameAdapter.addItem(PlayerNameItem(text))
        mNameInputView.text = null
    }

    private fun getPlayerNames(): ArrayList<String> {
        val names = ArrayList<String>()
        mNameAdapter.mItemList.forEach { names.add(it.getName()) }
        return names
    }

}