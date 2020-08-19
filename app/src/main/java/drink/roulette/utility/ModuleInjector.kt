package drink.roulette.utility


class ModuleInjector {
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

    fun initModules(modules: Array<Any>) {
        mModuleMap.clear()
        modules.forEach { module -> mModuleMap[module::class.java] = module }
    }
}