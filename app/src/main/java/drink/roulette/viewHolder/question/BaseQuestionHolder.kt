package drink.roulette.viewHolder.question

import android.view.View
import drink.roulette.model.questions.question.BaseQuestionItem
import drink.roulette.viewHolder.BaseChallengeQuestionHolder

abstract class BaseQuestionHolder<Item : BaseQuestionItem>(itemView: View) :
    BaseChallengeQuestionHolder<Item>(itemView)