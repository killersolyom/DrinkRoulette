package drink.roulette.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import drink.roulette.R
import drink.roulette.adapter.QuestionAdapter
import drink.roulette.model.questions.BaseDefaultQuestion
import drink.roulette.utility.BundleUtil
import drink.roulette.utility.ModuleInjector
import drink.roulette.utility.QuestionManager

class QuestionFragment : BaseFragment() {

    private lateinit var mBundleUtil: BundleUtil
    private lateinit var mQuestionManager: QuestionManager

    private lateinit var mPlayerNames: ArrayList<String>
    private lateinit var mQuestionList: ArrayList<BaseDefaultQuestion>

    private lateinit var mQuestionAdapter: QuestionAdapter
    private lateinit var mQuestionRecyclerView: RecyclerView
    private lateinit var mNextButton: View

    override fun getLayoutId(): Int {
        return R.layout.fragment_question
    }

    override fun findView(view: View) {
        mQuestionRecyclerView = view.findViewById(R.id.question_recycler_view)
        mNextButton = view.findViewById(R.id.next_button)
    }

    override fun injectModules() {
        super.injectModules()
        mBundleUtil = ModuleInjector.get(BundleUtil::class.java)
        mQuestionManager = ModuleInjector.get(QuestionManager::class.java)
    }

    override fun onInitializationFinished() {
        mQuestionAdapter = QuestionAdapter()
        mQuestionRecyclerView.layoutManager = LinearLayoutManager(context)
        mQuestionRecyclerView.adapter = mQuestionAdapter
        mNextButton.setOnClickListener { onNext() }
        mQuestionList = mQuestionManager.getRandomQuestions()
        onNext()
    }

    override fun loadArguments(bundle: Bundle) {
        if (mBundleUtil.canCast(bundle, PLAYER_LIST, ArrayList::class.java)) {
            mPlayerNames = bundle.get(PLAYER_LIST) as ArrayList<String>
        }
    }

    private fun onNext() {
        if (mQuestionList.isEmpty()) {
            Log.d(TAG, "Empty")
        } else {
            mQuestionAdapter.addItem(mQuestionList[0])
            mQuestionList.removeAt(0)
        }
    }

    companion object {
        private val PLAYER_LIST: String = "PLAYER_LIST"

        @JvmStatic
        fun newInstance(players: ArrayList<String>): BaseFragment {
            return QuestionFragment().apply {
                arguments = Bundle().apply { putSerializable(PLAYER_LIST, players) }
            }
        }
    }

}