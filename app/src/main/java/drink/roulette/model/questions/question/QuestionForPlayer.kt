package drink.roulette.model.questions.question

import drink.roulette.model.ViewType
import drink.roulette.model.questions.BaseDefaultQuestion

class QuestionForPlayer(id: Int, description: String, answer: String) : BaseQuestionItem(id, description, answer) {

    override fun getViewType(): Int {
        return ViewType.QUESTION_FOR_PLAYER_TYPE.type
    }

}