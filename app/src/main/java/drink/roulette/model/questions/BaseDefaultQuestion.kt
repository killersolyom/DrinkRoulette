package drink.roulette.model.questions

import drink.roulette.model.QuestionType

abstract class BaseDefaultQuestion {

    private var mId: Int = -1
    protected var mDescription: String = ""

    constructor(id: Int, description: String) : super() {
        this.mId = id
        mDescription = description
    }

    fun setDescription(description: String) {
        mDescription = description;
    }

    fun getId(): Int {
        return mId
    }

    abstract fun getQuestionType(): QuestionType

}