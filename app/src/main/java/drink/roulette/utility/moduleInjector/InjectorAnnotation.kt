package drink.roulette.utility.moduleInjector

import kotlin.reflect.KClass

interface InjectorAnnotation {
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.FIELD)
    annotation class Inject(val value: KClass<*>)
}