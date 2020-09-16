package drink.roulette.viewHolder.question

import android.view.View
import drink.roulette.R
import drink.roulette.model.questions.question.QuestionForPlayer

class QuestionForPlayerHolder(itemView: View) :
    BaseQuestionHolder<QuestionForPlayer>(itemView) {

    override fun getItemText(item: QuestionForPlayer): String {
        return item.getQuestion()
    }

    override fun getTitle(): Int {
        return R.string.question_for_palyer
    }

}