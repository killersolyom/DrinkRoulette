package drink.roulette.model.questions.challenge

import drink.roulette.model.QuestionType

class DedicatedPlayerChallenge(id: Int, description: String) : BaseChallenge(id, description) {

    override fun getQuestionType(): QuestionType {
        return QuestionType.TWO_PLAYER_CHALLENGE_TYPE
    }
}