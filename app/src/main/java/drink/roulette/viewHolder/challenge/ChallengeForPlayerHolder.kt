package drink.roulette.viewHolder.challenge

import android.view.View
import drink.roulette.R
import drink.roulette.model.ReplaceKeys
import drink.roulette.model.questions.challenge.DedicatedPlayerChallenge
import java.util.concurrent.ThreadLocalRandom

open class ChallengeForPlayerHolder(itemView: View) :
    BaseChallengeHolder<DedicatedPlayerChallenge>(itemView) {

    override fun getItemText(item: DedicatedPlayerChallenge): String {
        return insertRandomName(item)
    }

    override fun getTitle(): Int {
        return R.string.dedicated_challenge
    }

    private fun insertRandomName(item: DedicatedPlayerChallenge): String {
        val players = item.getPlayerNames()
        val name = players[ThreadLocalRandom.current().nextInt(0, players.size)]
        return item.getChallengeDescription().replace(ReplaceKeys.PLAYER.property, name)
    }
}