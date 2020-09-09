package drink.roulette.model.questions.answer

import drink.roulette.model.DefaultItem
import drink.roulette.viewHolder.ViewType

open class EndMessage(id: Int, private var mMessage: String) : DefaultItem() {

    private var mId: Int = id

    fun getMessage(): String {
        return mMessage
    }

    override fun getViewType(): ViewType {
        return ViewType.END_MESSAGE_TYPE
    }

    fun getId(): Int {
        return mId
    }
}