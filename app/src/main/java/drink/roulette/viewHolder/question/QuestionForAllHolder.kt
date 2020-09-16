package drink.roulette.viewHolder.question

import android.view.View
import drink.roulette.R
import drink.roulette.model.questions.question.QuestionForAll

class QuestionForAllHolder(itemView: View) : BaseQuestionHolder<QuestionForAll>(itemView) {
    override fun getItemText(item: QuestionForAll): String {
        return item.getQuestion()
    }

    override fun getTitle(): Int {
        return R.string.question_for_all
    }
}