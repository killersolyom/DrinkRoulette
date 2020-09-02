package drink.roulette.model.questions.question

import drink.roulette.viewHolder.ViewType

class QuestionForPlayer(id: Int, description: String, answer: String) :
    BaseQuestionItem(id, description, answer) {

    override fun getViewType(): ViewType {
        return ViewType.QUESTION_FOR_PLAYER_TYPE
    }

}