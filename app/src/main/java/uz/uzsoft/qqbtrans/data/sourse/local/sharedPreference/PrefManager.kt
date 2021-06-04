package uz.uzsoft.qqbtrans.data.sourse.local.sharedPreference

import android.content.Context
import android.content.SharedPreferences

private const val TOKEN = "token"
private const val FIREBASE_TOKEN = "firebase_token"
private const val NAME = "name"
private const val EMAIL = "email"
private const val PHONE = "phone"
private const val MY_AGENT = "my_agent"
private const val LOCALE_LANG = "localeLang"
private const val CARDS_LIST = "cardsList"
private const val CARD = "card"
private const val LOCATIONS_LIST = "locations_list"
private const val LOCATION = "loc_pin"
private const val CURRENT_ORDER_ID = "current_order_id"
private const val ORDER_STATUS = "order_status"
private const val ORDER_TITLE = "order_title"
private const val IS_LOGGED_IN = "is_logged_in"
private const val USER_ID = "user_id"


private fun getInstance(context: Context): SharedPreferences {
    return context.getSharedPreferences(MY_AGENT, Context.MODE_PRIVATE)
}

fun Context.saveToken(token: String) {
    getInstance(this).edit().putString(
        TOKEN, token
    )
        .apply()
}

fun Context.getToken(): String {
    return getInstance(this).getString(
        TOKEN, ""
    ) ?: ""
}

fun Context.isUserLoggedIn(): Boolean {
    return getToken().isNotEmpty()
}

fun Context.setLoggedOut() {
    getInstance(this).edit().putBoolean(IS_LOGGED_IN, false).apply()
}

fun Context.logout() {
    this.saveToken("")
    this.setLoggedOut()
}

fun Context.isLoggedin(): Boolean {
    return getInstance(this).getBoolean(IS_LOGGED_IN, false)
}

fun Context.loggedIn() {
    getInstance(this).edit().putBoolean(IS_LOGGED_IN, true).apply()
}

class PrefManager {
    companion object {

        private fun getInstance(context: Context): SharedPreferences {
            return context.getSharedPreferences(MY_AGENT, Context.MODE_PRIVATE)
        }

        fun saveToken(context: Context, token: String) {
            getInstance(context).edit().putString(
                TOKEN, token
            ).apply()
        }

        fun getToken(context: Context): String {
            return getInstance(
                context
            ).getString(TOKEN, "")!!
        }

        fun removeToken(context: Context) {
            getInstance(context).edit().remove(
                TOKEN
            ).apply()
        }

        fun saveFirebaseToke(context: Context, firebase_token: String) {
            getInstance(context).edit().putString(FIREBASE_TOKEN, firebase_token).apply()
        }

        fun getFirebaseToken(context: Context): String {
            return getInstance(context).getString(FIREBASE_TOKEN, "")!!
        }

        fun saveName(context: Context, name: String) {
            getInstance(context).edit().putString(NAME, name).apply()
        }

        fun getName(context: Context): String {
            return getInstance(context).getString(NAME, "")!!
        }

        fun saveEmail(context: Context, email: String) {
            getInstance(context).edit().putString(
                EMAIL, email
            ).apply()
        }

        fun getEmail(context: Context): String {
            return getInstance(context).getString(EMAIL, "")!!
        }

        fun savePhone(context: Context, phone: String) {
            getInstance(context).edit().putString(
                PHONE, phone
            ).apply()
        }

        fun getPhone(context: Context): String {
            return getInstance(context).getString(PHONE, "")!!
        }

        fun isUserLoggedIn(context: Context): Boolean {
            return getToken(context).isNotEmpty()
        }

        fun saveLocale(context: Context, localeLang: String) {
            getInstance(context).edit().putString(LOCALE_LANG, localeLang)
        }

        fun getLocale(context: Context): String {
            return getInstance(context).getString(LOCALE_LANG, "")!!
        }

        fun saveCurrentOrderId(context: Context, orderId: Int) {
            getInstance(context).edit().putInt(CURRENT_ORDER_ID,orderId).apply()
        }

        fun getCurrentOrderId(context: Context):Int{
            return getInstance(context).getInt(CURRENT_ORDER_ID,-1)
        }

        fun saveOrderStatus(context: Context,orderStatus:Boolean){
            getInstance(context).edit().putBoolean(ORDER_STATUS,orderStatus).apply()
        }

        fun isOrderActivity(context: Context):Boolean{
            return getInstance(context).getBoolean(ORDER_STATUS,false)
        }

        fun saveOrderTitle(context: Context,orderTitle:String){
            getInstance(context).edit().putString(ORDER_TITLE,orderTitle).apply()
        }

        fun getOrderTitle(context: Context):String{
            return getInstance(context).getString(ORDER_TITLE,"")!!
        }

        fun saveUserId(context: Context,userId:Int){
            getInstance(context).edit().putInt(USER_ID,userId).apply()
        }

        fun getUserId(context: Context): Int{
           return getInstance(context).getInt(USER_ID,-1)
        }
    }
}