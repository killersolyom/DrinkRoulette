package drink.roulette.data

import android.content.Context
import drink.roulette.R
import drink.roulette.model.JsonPropertyName
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

    private fun getJson(context: Context): JSONObject {
        val input: InputStream = context.resources.openRawResource(R.raw.questions_data)
        val text = String(input.readBytes())
        input.close()
        return JSONObject(text)
    }

    fun parseJson(context: Context) {
        val questionList = getJson(context).getJSONArray(JsonPropertyName.QUESTIONS.name)
        for (it in 0 until questionList.length()) {
            val questionGroup = questionList.get(it) as JSONObject
            val type: String = questionGroup.getString(JsonPropertyName.TYPE.name)
            val categoryQuestions = questionGroup.getJSONArray(JsonPropertyName.QUESTION_GROUP.name)
            parseItem(type, categoryQuestions)
        }
    }

    private fun parseItem(itemType: String, itemList: JSONArray) {
        for (it in 0 until itemList.length()) {
            val questionItem = itemList[it] as JSONObject
            val id: Int = questionItem.getInt(JsonPropertyName.ID.name)
            val question: String = getStringOrDefault(questionItem, JsonPropertyName.QUESTION)
            val answer: String = getStringOrDefault(questionItem, JsonPropertyName.ANSWER)

            when (itemType) {
                JsonPropertyName.SIMPLE_QUESTION_FOR_ALL.name ->
                    mQuestionForAll.add(QuestionForAll(id, question, answer))
                JsonPropertyName.PLAYER_DEDICATED_QUESTION.name ->
                    mQuestionForPlayer.add(QuestionForPlayer(id, question, answer))
                JsonPropertyName.PLAYER_DEDICATED_CHALLENGE.name ->
                    mChallengeForPlayer.add(DedicatedPlayerChallenge(id, question))
                JsonPropertyName.TWO_PLAYER_DEDICATED_CHALLENGE.name ->
                    mChallengeForTwoPlayer.add(TwoPlayerChallenge(id, question))
                JsonPropertyName.CHALLENGE_FOR_ALL.name ->
                    mChallengeForAll.add(ChallengeForAll(id, question))
            }
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

}