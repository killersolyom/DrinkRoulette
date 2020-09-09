package drink.roulette.viewHolder.challenge

import android.view.View
import drink.roulette.model.questions.challenge.ChallengeForAll

open class ChallengeForAllHolder(itemView: View) : BaseChallengeHolder<ChallengeForAll>(itemView) {
    override fun getItemText(item: ChallengeForAll): String {
        return item.getChallengeDescription()
    }
}