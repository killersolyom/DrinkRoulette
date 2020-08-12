package drink.roulette.utility.moduleInjector

class ModuleInjector {
    internal companion object {
        @JvmStatic

        private var mModuleMap: HashMap<Class<*>, Any> = HashMap()

        fun inject(target: Any) {
            (target::class.java).fields
                .filter { filed -> filed.getAnnotation(InjectModule::class.java) != null }
                .forEach { item -> item.set(target, mModuleMap[item.type]) }
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