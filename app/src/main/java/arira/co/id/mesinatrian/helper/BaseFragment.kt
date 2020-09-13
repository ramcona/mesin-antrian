package arira.co.id.mesinatrian.helper

import android.view.View
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment(){

    lateinit var pref: SharedPref
    lateinit var root: View
    lateinit var myDialog: MyDialog
    var toast = HelperToast()


}