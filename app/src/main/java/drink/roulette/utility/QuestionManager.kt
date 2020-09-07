package drink.roulette.utility

import android.content.Context
import drink.roulette.data.JsonDataParser
import drink.roulette.model.questions.BaseDefaultQuestion

class QuestionManager(mContext: Context) {

    private val mDataParser: JsonDataParser = JsonDataParser()

    init {
        mDataParser.parseJson(mContext)
    }

    fun getRandomQuestions(): ArrayList<BaseDefaultQuestion> {
        val questionList = ArrayList<BaseDefaultQuestion>()
        questionList.addAll(mDataParser.getQuestionForAllList())
        questionList.addAll(mDataParser.getPlayerDedicatedQuestionList())
        questionList.addAll(mDataParser.getChallengeForAllList())
        questionList.addAll(mDataParser.getDedicatedChallengeForPlayerList())
        questionList.addAll(mDataParser.getTwoPlayerChallengeList())
        questionList.shuffle()
        return questionList
    }

}