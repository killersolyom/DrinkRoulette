package drink.roulette.viewHolder.challenge

import android.view.View
import drink.roulette.R
import drink.roulette.model.questions.challenge.ChallengeForAll

open class ChallengeForAllHolder(itemView: View) : BaseChallengeHolder<ChallengeForAll>(itemView) {

    override fun getTitle(): Int {
        return R.string.challenge_for_all
    }
}