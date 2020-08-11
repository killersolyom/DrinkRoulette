package drink.roulette.utility.moduleInjector

import drink.roulette.activity.BaseActivity
import drink.roulette.utility.DataManager
import drink.roulette.utility.FragmentNavigation
import drink.roulette.utility.QuestionManager

class ModuleInjector {
    internal companion object {
        @JvmStatic

        private lateinit var mModuleMap: HashMap<Class<*>, Any>

        private fun <Type> getModule(type: Class<Type>): Type? {
            val item = mModuleMap[type]
            if (item != null) {
                if (item::class.java == type) {
                    return type.cast(item)
                }
            }

            return null
        }

        fun inject(target: Any) {
            (target::class.java).fields.forEach {
                val field = it.getAnnotation(InjectModule::class.java)
                if (field != null) {
                    val module = getModule(field.value.java)
                    if (module != null) {
                        it.set(target, module)
                    }
                }
            }
        }

        fun destroy() {
            mModuleMap.clear()
        }
    }

    fun initModules(activity: BaseActivity) {
        mModuleMap = HashMap()
        addModule(activity)
        addModule(FragmentNavigation(activity))
        addModule(DataManager(activity))
        addModule(QuestionManager(activity))
    }

    private fun addModule(module: Any) {
        mModuleMap[module::class.java] = module
    }

}