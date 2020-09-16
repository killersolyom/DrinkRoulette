package drink.roulette.model.questions.question

import drink.roulette.model.ReplaceKeys
import drink.roulette.viewHolder.ViewType
import drink.roulette.viewHolder.playerNames.PlayerNamesCallback
import java.util.concurrent.ThreadLocalRandom

class QuestionForPlayer(id: Int, description: String, answer: String) :
    BaseQuestionItem(id, description, answer), PlayerNamesCallback {

    override fun addPlayerNames(names: ArrayList<String>) {
        val name = names[ThreadLocalRandom.current().nextInt(0, names.size)]
        mDescription = mDescription.replace(ReplaceKeys.PLAYER.property, name)
    }

    override fun getViewType(): ViewType {
        return ViewType.QUESTION_FOR_PLAYER_TYPE
    }

}