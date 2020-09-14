package drink.roulette.utility

import android.content.Context
import drink.roulette.data.JsonDataParser
import drink.roulette.model.DefaultItem
import drink.roulette.model.questions.BaseDefaultQuestion
import drink.roulette.model.questions.endMessage.EndMessage
import drink.roulette.model.questions.question.BaseQuestionItem
import drink.roulette.model.questions.question.QuestionForAll

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
            if (it is BaseQuestionItem && it !is QuestionForAll) {
                questionList.add(it.getAnswer())
            }
        }

        questionList.add(EndMessage(mDataParser.getEndMessage()))

        return questionList
    }

    private fun getRandomItems(values: ArrayList<*>): ArrayList<BaseDefaultQuestion> {
        val items: ArrayList<Any> = ArrayList()
        items.addAll(values)
        items.shuffle()

        if (NUMBER_OF_ITEMS == 0) {
            return castToDefaultQuestion(null)
        }

        if (NUMBER_OF_ITEMS == 1) {
            val returnList: ArrayList<Any> = ArrayList()
            returnList.add(items[0])
            return castToDefaultQuestion(returnList)
        }

        if (NUMBER_OF_ITEMS >= items.size) {
            castToDefaultQuestion(items)
        }

        return castToDefaultQuestion(items.subList(0, NUMBER_OF_ITEMS))
    }

    private fun castToDefaultQuestion(values: MutableList<Any>?): ArrayList<BaseDefaultQuestion> {
        return if (values == null) return ArrayList() else values as ArrayList<BaseDefaultQuestion>
    }

}