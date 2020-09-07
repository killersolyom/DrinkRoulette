package drink.roulette.model.questions.question

import drink.roulette.model.questions.BaseDefaultQuestion

abstract class BaseQuestionItem(id: Int, question: String, answer: String) :
    BaseDefaultQuestion(id, question) {

    private var mAnswer: String = answer

    fun getAnswer(): String {
        return mAnswer
    }

    fun getQuestion(): String {
        return mDescription
    }

}