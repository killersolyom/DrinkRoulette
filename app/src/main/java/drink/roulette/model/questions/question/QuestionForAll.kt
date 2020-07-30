package drink.roulette.model.questions.question

import drink.roulette.model.QuestionType

class QuestionForAll(id: Int, description: String, answer: String) :
    BaseQuestionItem(id, description, answer) {

    override fun getQuestionType(): QuestionType {
        return QuestionType.QUESTION_FOR_ALL_TYPE
    }

}