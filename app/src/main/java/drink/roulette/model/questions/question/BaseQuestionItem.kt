package drink.roulette.model.questions.question

import drink.roulette.model.questions.BaseDefaultQuestion
import drink.roulette.model.questions.answer.BaseAnswer

abstract class BaseQuestionItem(id: Int, question: String, answer: String) :
    BaseDefaultQuestion(id, question) {

    private var mAnswer: BaseAnswer = BaseAnswer(id, answer)

    fun getAnswer(): BaseAnswer {
        return mAnswer
    }

    fun getQuestion(): String {
        return mDescription
    }

}