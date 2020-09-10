package drink.roulette.viewHolder.challenge

import android.view.View
import drink.roulette.R
import drink.roulette.model.questions.challenge.DedicatedPlayerChallenge

open class ChallengeForPlayerHolder(itemView: View) :
    BaseChallengeHolder<DedicatedPlayerChallenge>(itemView) {
    override fun getItemText(item: DedicatedPlayerChallenge): String {
        return item.getChallengeDescription()
    }

    override fun getTitle(): Int {
        return R.string.dedicated_challenge
    }
}