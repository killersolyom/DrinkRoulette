package drink.roulette.model.questions.question

import drink.roulette.model.ViewType

class QuestionForAll(id: Int, description: String, answer: String) :
    BaseQuestionItem(id, description, answer) {

    override fun getViewType(): Int {
        return ViewType.QUESTION_FOR_ALL_TYPE.type
    }

}