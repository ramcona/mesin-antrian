package arira.co.id.mesinatrian.ui.activity.dataBaru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import arira.co.id.mesinatrian.R
import arira.co.id.mesinatrian.app.App.Companion.pref
import arira.co.id.mesinatrian.helper.BaseActivity
import arira.co.id.mesinatrian.model.TempatModel
import arira.co.id.mesinatrian.ui.activity.main.MainActivity
import kotlinx.android.synthetic.main.activity_data.*

class DataActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        statusPutih()

        ldata_switch.isChecked = true
        ldata_div_simpan.setOnClickListener {
            val loket = ldata_edt_loket.text.toString()
            val admin = ldata_edt_admin.text.toString()
            val tempat = ldata_edt_tempat.text.toString()
            val kode = ldata_edt_kode.text.toString()
            if (loket.isEmpty()){
                toast.show(getString(R.string.lengkapi_data), this@DataActivity)
            }else if (admin.isEmpty()){
                toast.show(getString(R.string.lengkapi_data), this@DataActivity)
            }else if (tempat.isEmpty()){
                toast.show(getString(R.string.lengkapi_data), this@DataActivity)
            }else{
                val mTempat  = TempatModel()
                mTempat.admin = admin
                mTempat.antrian = "1"
                mTempat.audio = ldata_switch.isChecked
                mTempat.layarOn = ldata_switch_layar.isChecked
                mTempat.loket = loket
                mTempat.tempat = tempat
                mTempat.kodeAntrian = kode

                pref.setData(mTempat)

                startActivity(Intent(this@DataActivity, MainActivity::class.java))
                this@DataActivity.finish()
            }
        }
    }
}