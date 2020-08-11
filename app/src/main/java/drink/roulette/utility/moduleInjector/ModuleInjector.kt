package drink.roulette.utility.moduleInjector

import drink.roulette.activity.BaseActivity
import drink.roulette.utility.DataManager
import drink.roulette.utility.FragmentNavigation
import drink.roulette.utility.QuestionManager

class ModuleInjector {

    internal companion object {
        @JvmStatic
        private lateinit var mModuleMap: HashMap<Class<*>, Module>

        fun <Type> getModule(type: Class<Type>): Type {
            return type.cast(mModuleMap[type])!!
        }

        fun inject(target: Any) {
            var targetClass = target::class.java
            targetClass.fields.forEach {
                var field = it.getAnnotation(InjectorAnnotation.Inject::class.java)
                if (field != null) {
                    var asd = getModule(field.value.java)
                    it.isAccessible = true
                    it.set(target, asd)
                }
            }
        }
    }

    fun initModules(activity: BaseActivity) {
        mModuleMap = HashMap()
        addModule(activity)
        addModule(FragmentNavigation(activity))
        addModule(DataManager(activity))
        addModule(QuestionManager(activity))
    }

    private fun addModule(module: Module) {
        mModuleMap[module::class.java] = module
    }


}