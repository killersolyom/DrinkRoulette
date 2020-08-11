package drink.roulette.model.questions.question

import drink.roulette.model.questions.BaseDefaultQuestion

abstract class BaseQuestionItem(id: Int, description: String, answer: String) :
    BaseDefaultQuestion(id, description) {

    protected var mAnswer: String = answer

    fun setAnswer(answer: String) {
        mAnswer = answer
    }

    fun getAnswer(): String {
        return mAnswer
    }

}