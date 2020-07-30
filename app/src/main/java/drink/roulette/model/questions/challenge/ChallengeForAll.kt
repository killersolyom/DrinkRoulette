package drink.roulette.model.questions.challenge

import drink.roulette.model.ViewType

class ChallengeForAll(id: Int, description: String) : BaseChallenge(id, description) {

    override fun getViewType(): Int {
        return ViewType.TWO_PLAYER_CHALLENGE_TYPE.type
    }
}