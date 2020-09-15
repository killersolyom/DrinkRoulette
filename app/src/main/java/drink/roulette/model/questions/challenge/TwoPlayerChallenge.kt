package drink.roulette.model.questions.challenge

import drink.roulette.model.playerName.PlayerNames
import drink.roulette.viewHolder.ViewType
import drink.roulette.viewHolder.playerNames.PlayerNamesCallback

class TwoPlayerChallenge(id: Int, description: String) : BaseChallenge(id, description),
    PlayerNamesCallback {

    private lateinit var mPlayerNames: PlayerNames

    override fun setPlayerNames(names: PlayerNames) {
        mPlayerNames = names
    }

    override fun getPlayerNames(): ArrayList<String> {
        return mPlayerNames.getPlayerNames()
    }

    override fun getViewType(): ViewType {
        return ViewType.TWO_PLAYER_CHALLENGE_TYPE
    }
}