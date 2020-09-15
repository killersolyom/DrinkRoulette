package drink.roulette.viewHolder.question

import android.view.View
import drink.roulette.R
import drink.roulette.model.ReplaceKeys.PLAYER
import drink.roulette.model.questions.question.QuestionForPlayer
import java.util.concurrent.ThreadLocalRandom

class QuestionForPlayerHolder(itemView: View) :
    BaseQuestionHolder<QuestionForPlayer>(itemView) {

    override fun getItemText(item: QuestionForPlayer): String {
        return insertRandomName(item)
    }

    override fun getTitle(): Int {
        return R.string.question_for_palyer
    }

    private fun insertRandomName(item: QuestionForPlayer): String {
        val players = item.getPlayerNames()
        val name = players[ThreadLocalRandom.current().nextInt(0, players.size)]
        return item.getQuestion().replace(PLAYER.property, name)
    }
}