package drink.roulette.model.questions.question

import drink.roulette.model.playerName.PlayerNames
import drink.roulette.viewHolder.ViewType
import drink.roulette.viewHolder.playerNames.PlayerNamesCallback

class QuestionForPlayer(id: Int, description: String, answer: String) :
    BaseQuestionItem(id, description, answer), PlayerNamesCallback {

    private lateinit var mPlayerNames: PlayerNames

    override fun setPlayerNames(names: PlayerNames) {
        mPlayerNames = names
    }

    override fun getPlayerNames(): ArrayList<String> {
        return mPlayerNames.getPlayerNames()
    }

    override fun getViewType(): ViewType {
        return ViewType.QUESTION_FOR_PLAYER_TYPE
    }

}