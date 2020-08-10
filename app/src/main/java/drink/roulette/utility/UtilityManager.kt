package drink.roulette.utility

import drink.roulette.activity.MainActivity

class UtilityManager {

    internal companion object {
        @JvmStatic
        fun initUtilities(activity: MainActivity) {
            FragmentNavigation.initialize(activity)
            QuestionManager.initialize(activity.applicationContext)
            DataManager.initialize(activity)
        }
    }

}