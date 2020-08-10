package drink.roulette.utility

import android.content.Context
import android.content.SharedPreferences


class DataManager {

    internal companion object {
        @JvmStatic

        private lateinit var mPreference: SharedPreferences

        fun initialize(context: Context) {
            mPreference = context.getSharedPreferences(context.applicationContext.packageName, 0)
        }

        private fun clearItem(key: String) {
            mPreference.edit().remove(key).apply()
        }

        private fun writeBooleanData(value: Boolean, key: String) {
            mPreference.edit().putBoolean(key, value).apply()
        }

        private fun writeIntData(value: Int, key: String) {
            mPreference.edit().putInt(key, value).apply()
        }

        private fun writeLongData(number: Long, key: String) {
            mPreference.edit().putLong(key, number).apply()
        }

        private fun writeFloatData(number: Float, key: String) {
            mPreference.edit().putFloat(key, number).apply()
        }

        private fun writeString(value: String, key: String) {
            mPreference.edit().putString(key, value).apply()
        }

        private fun readBooleanData(key: String): Boolean {
            return mPreference.getBoolean(key, false)
        }

        private fun readIntData(key: String, defaultValue: Int): Int {
            return mPreference.getInt(key, defaultValue)
        }

        private fun readLongData(key: String, defaultValue: Long): Long {
            return mPreference.getLong(key, defaultValue)
        }

        private fun readFloatData(key: String, defaultValue: Float): Float {
            return mPreference.getFloat(key, defaultValue)
        }

        private fun readStringData(key: String, defaultValue: String): String? {
            return mPreference.getString(key, defaultValue)
        }

    }

}