package drink.roulette.utility

import android.content.Context
import drink.roulette.data.JsonDataParser
import drink.roulette.model.DefaultItem
import drink.roulette.model.questions.BaseDefaultQuestion
import drink.roulette.model.questions.answer.EndMessage
import drink.roulette.model.questions.question.BaseQuestionItem

class QuestionManager(mContext: Context) {

    private val mDataParser: JsonDataParser = JsonDataParser()
    private val NUMBER_OF_ITEMS = 10

    init {
        mDataParser.parseJson(mContext)
    }

    fun getRandomQuestions(): ArrayList<DefaultItem> {
        val questionItems = ArrayList<BaseDefaultQuestion>()
        questionItems.addAll(getRandomItems(mDataParser.getQuestionForAllList()))
        questionItems.addAll(getRandomItems(mDataParser.getPlayerDedicatedQuestionList()))
        questionItems.addAll(getRandomItems(mDataParser.getChallengeForAllList()))
        questionItems.addAll(getRandomItems(mDataParser.getDedicatedChallengeForPlayerList()))
        questionItems.addAll(getRandomItems(mDataParser.getTwoPlayerChallengeList()))

        val questionList = ArrayList<DefaultItem>()
        questionItems.forEach {
            questionList.add(it)

            if (it is BaseQuestionItem) {
                questionList.add(it.getAnswer())
            }

        }

        questionList.add(EndMessage(0, mDataParser.getEndMessage()))

        return questionList
    }

    private fun getRandomItems(values: ArrayList<*>): ArrayList<BaseDefaultQuestion> {
        val items: ArrayList<Any> = ArrayList()
        items.addAll(values)
        items.shuffle()

        if (NUMBER_OF_ITEMS >= items.size) {
            return items as ArrayList<BaseDefaultQuestion>
        }

        return items.subList(0, NUMBER_OF_ITEMS) as ArrayList<BaseDefaultQuestion>
    }

}