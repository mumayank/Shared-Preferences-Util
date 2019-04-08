class SharedPreferencesUtil {
    
    companion object {

        private fun getSharedPreferences(activity: Activity?): SharedPreferences? {
            val sharedPreferences = activity?.getSharedPreferences(activity.packageName, MODE_PRIVATE)
            if (sharedPreferences != null) {
                return sharedPreferences
            } else {
                return null
            }
        }

        @JvmStatic
        fun <T> get(activity: Activity?, @NonNull key: String, @NonNull defaultValue: T): T {
            if (activity == null) {
                return defaultValue
            }
            val sharedPreferences= getSharedPreferences(activity) ?: return defaultValue

            when (defaultValue) {
                is Boolean -> return sharedPreferences.getBoolean(key, defaultValue) as T ?: return defaultValue
                is Int -> return sharedPreferences.getInt(key, defaultValue) as T ?: return defaultValue
                is String -> return sharedPreferences.getString(key, defaultValue) as T ?: return defaultValue
                is Float -> return sharedPreferences.getFloat(key, defaultValue) as T ?: return defaultValue
                is Long -> return sharedPreferences.getLong(key, defaultValue) as T ?: return defaultValue
                else -> return defaultValue
            }
        }

        @JvmStatic
        fun <T> put(activity: Activity?, @NonNull key: String, @NonNull value: T) {
            if (activity == null) {
                return
            }
            val sharedPreferences= getSharedPreferences(activity) ?: return

            when (value) {
                is Boolean -> sharedPreferences.edit().putBoolean(key, value).commit()
                is Int -> sharedPreferences.edit().putInt(key, value).commit()
                is String -> sharedPreferences.edit().putString(key, value).commit()
                is Float -> sharedPreferences.edit().putFloat(key, value).commit()
                is Long -> sharedPreferences.edit().putLong(key, value).commit()
            }
        }

    }
    
}
