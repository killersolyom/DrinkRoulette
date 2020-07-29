package drink.roulette.utility

import android.content.Context
import drink.roulette.data.JsonDataParser

class QuestionManager {

    internal companion object {
        @JvmStatic

        // Data Parser
        private val dataParser: JsonDataParser = JsonDataParser()

        fun initialize(context: Context) {
            dataParser.parseJson(context)
        }

    }

}