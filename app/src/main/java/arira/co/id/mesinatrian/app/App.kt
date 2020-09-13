package arira.co.id.mesinatrian.app

import android.app.Application
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.room.Room
import arira.co.id.mesinatrian.database.AppDatabase
import arira.co.id.mesinatrian.helper.HelperToast
import arira.co.id.mesinatrian.helper.MyDialog
import arira.co.id.mesinatrian.helper.SharedPref
import com.google.android.material.bottomsheet.BottomSheetBehavior

class App : Application() {

    companion object {
        var toast = HelperToast()
        lateinit var myDialog: MyDialog
        private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

        val curdate:String = java.text.SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss",
            java.util.Locale("ID")
        ).format(
            java.util.Date()
        )
        lateinit var pref: SharedPref
        var db: AppDatabase? = null
    }


    override fun onCreate() {
        super.onCreate()
        pref = SharedPref(this)

        db = Room.databaseBuilder(
            getApplicationContext(),
            AppDatabase::class.java, "MesinAntrian"
        ).allowMainThreadQueries().build()
    }
}