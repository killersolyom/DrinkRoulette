package drink.roulette.viewHolder.playerNames

import drink.roulette.model.playerName.PlayerNames

interface PlayerNamesCallback {
    fun setPlayerNames(names: PlayerNames)
    fun getPlayerNames(): ArrayList<String>
}