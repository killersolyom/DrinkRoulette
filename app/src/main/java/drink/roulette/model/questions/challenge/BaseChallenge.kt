package drink.roulette.model.questions.challenge

import drink.roulette.model.questions.BaseDefaultQuestion

abstract class BaseChallenge(id: Int, description: String) : BaseDefaultQuestion(id, description) {

    public fun getChallengeDescription(): String {
        return this.mDescription
    }

}