package drink.roulette.utility.moduleInjector

import drink.roulette.activity.BaseActivity
import drink.roulette.utility.DataManager
import drink.roulette.utility.FragmentNavigation
import drink.roulette.utility.QuestionManager

class ModuleInjector {

    fun initModules(activity: BaseActivity) {
        mModuleMap = HashMap()
        addModule(activity)
        addModule(FragmentNavigation(activity))
        addModule(DataManager(activity))
        addModule(QuestionManager(activity))
    }

    private fun addModule(module: Module) {
        mModuleMap[module::class.java.canonicalName] = module
    }

    internal companion object {
        @JvmStatic

        private lateinit var mModuleMap: HashMap<String?, Module>

        fun <T : Module?> getModule(module: Class<T>): T? {
            return mModuleMap[module.canonicalName] as T
        }

    }

}