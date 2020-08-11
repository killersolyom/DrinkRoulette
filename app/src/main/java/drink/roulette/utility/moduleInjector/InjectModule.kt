package drink.roulette.utility.moduleInjector

import kotlin.reflect.KClass

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class InjectModule(val value: KClass<*>)