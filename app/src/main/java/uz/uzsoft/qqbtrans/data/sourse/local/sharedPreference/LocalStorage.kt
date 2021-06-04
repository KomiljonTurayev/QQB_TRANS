package uz.uzsoft.qqbtrans.data.sourse.local.sharedPreference

import android.content.Context
import android.content.SharedPreferences
import uz.uzsoft.qqbtrans.app.App


class LocalStorage(context: Context) {
    private var pref: SharedPreferences =
        context.getSharedPreferences("LocalStorage", Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = pref.edit()

    companion object {
        private var data: LocalStorage? = null
        fun getInstance(): LocalStorage {
            if (data == null) {
                data = LocalStorage(App.instance)
            }
            return data!!
        }
    }

    fun setToken(token: String?) {
        editor.putString("TOKEN", token)
        editor.apply()
    }

    fun getToken(): String? = pref.getString("TOKEN", "")

    fun setRemember(rem: Boolean) {
        editor.putBoolean("REMEMBER", rem)
        editor.apply()
    }

    fun getRemember():Boolean=pref.getBoolean("REMEMBER",false)

}