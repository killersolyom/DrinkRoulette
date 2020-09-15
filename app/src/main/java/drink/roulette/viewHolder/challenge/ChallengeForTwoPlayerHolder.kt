package drink.roulette.viewHolder.challenge

import android.view.View
import drink.roulette.R
import drink.roulette.model.ReplaceKeys
import drink.roulette.model.questions.challenge.TwoPlayerChallenge
import java.util.concurrent.ThreadLocalRandom

open class ChallengeForTwoPlayerHolder(itemView: View) :
    BaseChallengeHolder<TwoPlayerChallenge>(itemView) {

    override fun getItemText(item: TwoPlayerChallenge): String {
        return insertTwoRandomName(item)
    }

    override fun getTitle(): Int {
        return R.string.challenge_for_two_player
    }

    private fun insertTwoRandomName(item: TwoPlayerChallenge): String {
        val players = item.getPlayerNames()
        val random = ThreadLocalRandom.current().nextInt(0, players.size)
        return item.getChallengeDescription()
            .replaceFirst(ReplaceKeys.PLAYER.property, players[random])
            .replaceFirst(ReplaceKeys.PLAYER.property, players[(random + 1) % players.size])
    }

}