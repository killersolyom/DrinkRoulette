package drink.roulette.utility

import android.os.Bundle
import java.io.Serializable

class BundleUtil {
    fun isExist(bundle: Bundle?): Boolean {
        return bundle != null && !bundle.isEmpty
    }

    fun hasValueAt(bundle: Bundle, key: String?): Boolean {
        return isExist(bundle) && bundle[key] != null
    }

    fun canCast(bundle: Bundle, key: String, type: Class<*>?): Boolean {
        if (hasValueAt(bundle, key) && type != null) {
            val item = bundle[key]
            return item != null && type == item.javaClass
        }
        return false
    }

    fun createBundle(key: String?, item: Serializable?): Bundle? {
        val bundle = Bundle()
        bundle.putSerializable(key, item)
        return bundle
    }

    fun <Type> getItem(bundle: Bundle, key: String?, type: Class<Type>): Type? {
        return type.cast(bundle[key])
    }

    fun <Type> getItem(item: Any?, type: Class<Type>): Type? {
        return type.cast(item)
    }
}