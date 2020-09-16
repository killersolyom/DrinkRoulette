package drink.roulette.viewHolder.challenge

import android.view.View
import drink.roulette.R
import drink.roulette.model.questions.challenge.TwoPlayerChallenge

open class ChallengeForTwoPlayerHolder(itemView: View) :
    BaseChallengeHolder<TwoPlayerChallenge>(itemView) {

    override fun getTitle(): Int {
        return R.string.challenge_for_two_player
    }

}