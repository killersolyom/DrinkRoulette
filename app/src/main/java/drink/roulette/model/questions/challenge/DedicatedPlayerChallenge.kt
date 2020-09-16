package drink.roulette.model.questions.challenge

import drink.roulette.model.ReplaceKeys
import drink.roulette.viewHolder.ViewType
import drink.roulette.viewHolder.playerNames.PlayerNamesCallback
import java.util.concurrent.ThreadLocalRandom

class DedicatedPlayerChallenge(id: Int, description: String) : BaseChallenge(id, description),
    PlayerNamesCallback {

    override fun addPlayerNames(names: ArrayList<String>) {
        val name = names[ThreadLocalRandom.current().nextInt(0, names.size)]
        mDescription = mDescription.replace(ReplaceKeys.PLAYER.property, name)
    }

    override fun getViewType(): ViewType {
        return ViewType.DEDICATED_PLAYER_CHALLENGE_TYPE
    }

}