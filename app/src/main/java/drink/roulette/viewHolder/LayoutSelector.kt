package drink.roulette.viewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import drink.roulette.R
import drink.roulette.viewHolder.ViewType.*
import drink.roulette.viewHolder.answer.BaseAnswerHolder
import drink.roulette.viewHolder.challenge.ChallengeForAllHolder
import drink.roulette.viewHolder.challenge.ChallengeForPlayerHolder
import drink.roulette.viewHolder.challenge.ChallengeForTwoPlayerHolder
import drink.roulette.viewHolder.endMessage.EndMessageHolder
import drink.roulette.viewHolder.question.QuestionForAllHolder
import drink.roulette.viewHolder.question.QuestionForPlayerHolder

class LayoutSelector {

    companion object {
        @JvmStatic

        fun getLayoutForItem(p: ViewGroup, viewType: Int): DefaultViewHolder<*>? {
            when (viewType) {
                PLAYER_NAME_ITEM.type ->
                    return PlayerNameViewHolder(inflate(p, R.layout.player_name_layout))
                QUESTION_FOR_ALL_TYPE.type ->
                    return QuestionForAllHolder(inflate(p, R.layout.question_item_layout))
                QUESTION_FOR_PLAYER_TYPE.type ->
                    return QuestionForPlayerHolder(inflate(p, R.layout.question_item_layout))
                CHALLENGE_FOR_ALL_TYPE.type ->
                    return ChallengeForAllHolder(inflate(p, R.layout.question_item_layout))
                DEDICATED_PLAYER_CHALLENGE_TYPE.type ->
                    return ChallengeForPlayerHolder(inflate(p, R.layout.question_item_layout))
                TWO_PLAYER_CHALLENGE_TYPE.type ->
                    return ChallengeForTwoPlayerHolder(inflate(p, R.layout.question_item_layout))
                ANSWER_TYPE.type ->
                    return BaseAnswerHolder(inflate(p, R.layout.question_item_layout))
                END_MESSAGE_TYPE.type ->
                    return EndMessageHolder(inflate(p, R.layout.end_message_item_layout))
                else ->
                    return DefaultViewHolder<Any>(inflate(p, R.layout.default_layout))
            }
        }


        private fun inflate(parent: ViewGroup, layoutId: Int): View {
            return LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        }

    }
}