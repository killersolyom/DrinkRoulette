package drink.roulette.model.questions.challenge

import drink.roulette.viewHolder.ViewType

class TwoPlayerChallenge(id: Int, description: String) : BaseChallenge(id, description) {

    override fun getViewType(): ViewType {
        return ViewType.TWO_PLAYER_CHALLENGE_TYPE
    }
}