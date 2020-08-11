package drink.roulette.utility

import android.content.Context
import drink.roulette.data.JsonDataParser

class QuestionManager(mContext: Context) {

    private val mDataParser: JsonDataParser = JsonDataParser()

    init {
        mDataParser.parseJson(mContext)
    }

}