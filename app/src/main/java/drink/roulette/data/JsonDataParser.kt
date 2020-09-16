package drink.roulette.data

import android.content.Context
import drink.roulette.R
import drink.roulette.model.JsonPropertyName
import drink.roulette.model.JsonPropertyName.*
import drink.roulette.model.questions.challenge.ChallengeForAll
import drink.roulette.model.questions.challenge.DedicatedPlayerChallenge
import drink.roulette.model.questions.challenge.TwoPlayerChallenge
import drink.roulette.model.questions.question.QuestionForAll
import drink.roulette.model.questions.question.QuestionForPlayer
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream


class JsonDataParser {

    // Question Lists
    private var mQuestionForAll: ArrayList<QuestionForAll> = ArrayList()
    private var mQuestionForPlayer: ArrayList<QuestionForPlayer> = ArrayList()

    // Challenge Lists
    private var mChallengeForAll: ArrayList<ChallengeForAll> = ArrayList()
    private var mChallengeForPlayer: ArrayList<DedicatedPlayerChallenge> = ArrayList()
    private var mChallengeForTwoPlayer: ArrayList<TwoPlayerChallenge> = ArrayList()

    private lateinit var mEndMessage: String

    private fun getJson(context: Context): JSONObject {
        val input: InputStream = context.resources.openRawResource(R.raw.questions_data)
        val text = String(input.readBytes())
        input.close()
        return JSONObject(text)
    }

    fun parseJson(context: Context) {
        val questionList = getJson(context).getJSONArray(QUESTIONS.name)
        for (it in 0 until questionList.length()) {
            val questionGroup = questionList.get(it) as JSONObject
            val type: String = questionGroup.getString(TYPE.name)
            val categoryQuestions = questionGroup.getJSONArray(QUESTION_GROUP.name)
            parseItem(type, categoryQuestions)
        }
    }

    private fun parseItem(itemType: String, itemList: JSONArray) {
        for (it in 0 until itemList.length()) {
            val questionItem = itemList[it] as JSONObject

            val id: Int = questionItem.getInt(ID.name)

            when (itemType) {
                SIMPLE_QUESTION_FOR_ALL.name,
                PLAYER_DEDICATED_QUESTION.name -> {
                    val question: String = getStringOrDefault(questionItem, QUESTION)
                    val answer: String = getStringOrDefault(questionItem, ANSWER)
                    createQuestionObject(itemType, id, question, answer)
                }
                PLAYER_DEDICATED_CHALLENGE.name,
                TWO_PLAYER_DEDICATED_CHALLENGE.name,
                CHALLENGE_FOR_ALL.name -> {
                    val challenge: String = getStringOrDefault(questionItem, CHALLENGE)
                    createChallengeObject(itemType, id, challenge)
                }
                END_MESSAGE.name -> mEndMessage = getStringOrDefault(questionItem, END_MESSAGE)
            }
        }
    }

    private fun createQuestionObject(itemType: String, id: Int, question: String, answer: String) {
        when (itemType) {
            SIMPLE_QUESTION_FOR_ALL.name ->
                mQuestionForAll.add(QuestionForAll(id, question, answer))
            PLAYER_DEDICATED_QUESTION.name ->
                mQuestionForPlayer.add(QuestionForPlayer(id, question, answer))
        }
    }

    private fun createChallengeObject(itemType: String, id: Int, challenge: String) {
        when (itemType) {
            PLAYER_DEDICATED_CHALLENGE.name ->
                mChallengeForPlayer.add(DedicatedPlayerChallenge(id, challenge))
            TWO_PLAYER_DEDICATED_CHALLENGE.name ->
                mChallengeForTwoPlayer.add(TwoPlayerChallenge(id, challenge))
            CHALLENGE_FOR_ALL.name ->
                mChallengeForAll.add(ChallengeForAll(id, challenge))
        }
    }

    private fun getStringOrDefault(item: JSONObject, key: JsonPropertyName): String {
        return if (item.has(key.name)) item.getString(key.name) else ""
    }

    fun getQuestionForAllList(): ArrayList<QuestionForAll> {
        return mQuestionForAll
    }

    fun getPlayerDedicatedQuestionList(): ArrayList<QuestionForPlayer> {
        return mQuestionForPlayer
    }

    fun getChallengeForAllList(): ArrayList<ChallengeForAll> {
        return mChallengeForAll
    }

    fun getDedicatedChallengeForPlayerList(): ArrayList<DedicatedPlayerChallenge> {
        return mChallengeForPlayer
    }

    fun getTwoPlayerChallengeList(): ArrayList<TwoPlayerChallenge> {
        return mChallengeForTwoPlayer
    }

    fun getEndMessage(): String {
        return mEndMessage
    }

}
