package drink.roulette.viewHolder.answer

import android.view.View
import drink.roulette.R
import drink.roulette.model.questions.answer.BaseAnswer
import drink.roulette.viewHolder.QuestionTitleHolder

open class BaseAnswerHolder(itemView: View) : QuestionTitleHolder<BaseAnswer>(itemView) {
    override fun getItemText(item: BaseAnswer): String {
        return item.getAnswer()
    }

    override fun getTitle(): Int {
        return R.string.answer
    }
}