package drink.roulette.viewHolder.answer

import android.view.View
import drink.roulette.model.questions.answer.BaseAnswer
import drink.roulette.viewHolder.BaseChallengeQuestionHolder

open class BaseAnswerHolder(itemView: View) : BaseChallengeQuestionHolder<BaseAnswer>(itemView) {
    override fun getItemText(item: BaseAnswer): String {
        return item.getAnswer()
    }
}