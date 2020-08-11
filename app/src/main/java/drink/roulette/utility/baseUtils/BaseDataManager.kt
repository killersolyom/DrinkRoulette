package drink.roulette.utility.baseUtils

import android.content.SharedPreferences
import drink.roulette.activity.BaseActivity
import drink.roulette.utility.moduleInjector.Module


abstract class BaseDataManager(activity: BaseActivity) : Module {

    private var mPreference: SharedPreferences =
        activity.getSharedPreferences(activity.applicationContext.packageName, 0)

    internal fun clearItem(key: String) {
        mPreference.edit().remove(key).apply()
    }

    internal fun writeBooleanData(value: Boolean, key: String) {
        mPreference.edit().putBoolean(key, value).apply()
    }

    internal fun writeIntData(value: Int, key: String) {
        mPreference.edit().putInt(key, value).apply()
    }

    internal fun writeLongData(number: Long, key: String) {
        mPreference.edit().putLong(key, number).apply()
    }

    internal fun writeFloatData(number: Float, key: String) {
        mPreference.edit().putFloat(key, number).apply()
    }

    internal fun writeString(value: String, key: String) {
        mPreference.edit().putString(key, value).apply()
    }

    internal fun readBooleanData(key: String): Boolean {
        return mPreference.getBoolean(key, false)
    }

    internal fun readIntData(key: String, defaultValue: Int): Int {
        return mPreference.getInt(key, defaultValue)
    }

    internal fun readLongData(key: String, defaultValue: Long): Long {
        return mPreference.getLong(key, defaultValue)
    }

    internal fun readFloatData(key: String, defaultValue: Float): Float {
        return mPreference.getFloat(key, defaultValue)
    }

    internal fun readStringData(key: String, defaultValue: String): String? {
        return mPreference.getString(key, defaultValue)
    }

}