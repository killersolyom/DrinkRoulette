package drink.roulette.model.questions.challenge

import drink.roulette.viewHolder.ViewType

class ChallengeForAll(id: Int, description: String) : BaseChallenge(id, description) {

    override fun getViewType(): ViewType {
        return ViewType.CHALLENGE_FOR_ALL_TYPE
    }
}