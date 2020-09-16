package drink.roulette.model.questions.challenge

import drink.roulette.model.ReplaceKeys
import drink.roulette.viewHolder.ViewType
import drink.roulette.viewHolder.playerNames.PlayerNamesCallback
import java.util.concurrent.ThreadLocalRandom

class TwoPlayerChallenge(id: Int, description: String) : BaseChallenge(id, description),
    PlayerNamesCallback {

    override fun addPlayerNames(names: ArrayList<String>) {
        val random = ThreadLocalRandom.current().nextInt(0, names.size)
        mDescription = mDescription
            .replaceFirst(ReplaceKeys.PLAYER.property, names[random])
            .replaceFirst(ReplaceKeys.PLAYER.property, names[(random + 1) % names.size])
    }

    override fun getViewType(): ViewType {
        return ViewType.TWO_PLAYER_CHALLENGE_TYPE
    }
}