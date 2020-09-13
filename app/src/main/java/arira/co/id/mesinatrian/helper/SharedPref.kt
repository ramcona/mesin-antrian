package arira.co.id.mesinatrian.helper

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import arira.co.id.mesinatrian.model.TempatModel
import com.google.gson.Gson

class SharedPref(context : Context) {

    val idUser = "id"
    val token = "Session"

    private val statusLogin = "login"

    private val user = "user"
    private val datas = "datas"
    private val IS_FIRST_LAUNCH = "is_first_launch"

    // Main PREF
    private val mypref = "MAIN_PREF"
    private val sp: SharedPreferences
    private val prefs: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        sp = context.getSharedPreferences(mypref, Context.MODE_PRIVATE)
        prefs = PreferenceManager.getDefaultSharedPreferences(context)
        editor = sp.edit()
    }

    fun setIsFirstLaunchToFalse() {
        editor.putBoolean(IS_FIRST_LAUNCH, false)
        editor.commit()
    }

    fun isFirstLaunch() : Boolean {
        return sp.getBoolean(IS_FIRST_LAUNCH, true)
    }

    fun setData(model:TempatModel){
        val json = Gson().toJson(model, TempatModel::class.java)
        sp.edit().putString(datas, json).apply()
    }

    fun getData():TempatModel{
        val data:String = sp.getString(datas, null) ?: return TempatModel()
        return Gson().fromJson(data, TempatModel::class.java)
    }

//    // Setting User
//    fun setUser(data: UserModel?): UserModel? {
//        if (data == null) return null
//        val json = Gson().toJson(data, UserModel::class.java)
//        sp.edit().putString(user, json).apply()
//        return getUser()
//    }
//
//    fun getUser(): UserModel? {
//        val data = sp.getString(user, null) ?: return null
//        return Gson().fromJson<UserModel>(data, UserModel::class.java)
//    }

    //---------------End-----------

    fun setString(keySP: String, value: String) {
        editor.putString(keySP, value)
        editor.commit()
    }

    fun getId(): String {
        return sp.getString(idUser, "")!!
    }

    fun getSession(): String {
        return sp.getString(token, "")!!
    }

    fun clearAll() {
        editor.clear()
        editor.commit()
    }


}