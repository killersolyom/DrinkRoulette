package drink.roulette.viewHolder.endMessage

import android.view.View
import drink.roulette.model.questions.endMessage.EndMessage
import drink.roulette.viewHolder.BaseChallengeQuestionHolder

open class EndMessageHolder(itemView: View) : BaseChallengeQuestionHolder<EndMessage>(itemView) {
    override fun getItemText(item: EndMessage): String {
        return item.getMessage()
    }

    override fun getTitle(): Int {
        return -1
    }
}