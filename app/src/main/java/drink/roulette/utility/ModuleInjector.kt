package drink.roulette.utility


class ModuleInjector {

    init {
        mModuleMap.clear()
    }

    internal companion object {
        @JvmStatic

        private var mModuleMap: HashMap<Class<*>, Any> = HashMap()

        fun <Type> get(module: Class<Type>): Type {
            return mModuleMap[module] as Type
        }
    }

    fun destroy() {
        mModuleMap.clear()
    }

    fun addModules(modules: Array<Any>) {
        modules.forEach { module -> mModuleMap[module::class.java] = module }
    }

    fun addModule(module: Any) {
        mModuleMap[module::class.java] = module
    }
}