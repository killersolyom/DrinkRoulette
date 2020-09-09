package drink.roulette.viewHolder.challenge

import android.view.View
import drink.roulette.model.questions.challenge.DedicatedPlayerChallenge

open class ChallengeForPlayerHolder(itemView: View) :
    BaseChallengeHolder<DedicatedPlayerChallenge>(itemView) {
    override fun getItemText(item: DedicatedPlayerChallenge): String {
        return item.getChallengeDescription()
    }
}