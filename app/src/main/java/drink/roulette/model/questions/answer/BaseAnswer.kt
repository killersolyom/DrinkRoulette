package drink.roulette.model.questions.answer

import drink.roulette.model.DefaultItem
import drink.roulette.viewHolder.ViewType

open class BaseAnswer(id: Int, private var mAnswer: String) : DefaultItem() {

    private var mId: Int = id

    fun getAnswer(): String {
        return mAnswer
    }

    override fun getViewType(): ViewType {
        return ViewType.ANSWER_TYPE
    }

    fun getId(): Int {
        return mId
    }
}