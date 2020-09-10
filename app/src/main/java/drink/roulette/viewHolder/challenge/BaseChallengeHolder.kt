package drink.roulette.viewHolder.challenge

import android.view.View
import drink.roulette.model.questions.challenge.BaseChallenge
import drink.roulette.viewHolder.QuestionTitleHolder

abstract class BaseChallengeHolder<Item : BaseChallenge>(itemView: View) :
    QuestionTitleHolder<Item>(itemView)