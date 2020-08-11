package drink.roulette.utility

import android.content.Context
import drink.roulette.data.JsonDataParser
import drink.roulette.utility.moduleInjector.Module

class QuestionManager(mContext: Context) : Module {

    private val mDataParser: JsonDataParser = JsonDataParser()

    init {
        mDataParser.parseJson(mContext)
    }


}