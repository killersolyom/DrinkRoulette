package drink.roulette.model.questions.endMessage

import drink.roulette.model.DefaultItem
import drink.roulette.viewHolder.ViewType

open class EndMessage(id: Int, private var mMessage: String) : DefaultItem() {

    constructor(endMessage: String) : this(0, endMessage)

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