package arira.co.id.mesinatrian.ui.activity.pengaturan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import arira.co.id.mesinatrian.R
import arira.co.id.mesinatrian.app.App.Companion.pref
import arira.co.id.mesinatrian.helper.BaseActivity
import arira.co.id.mesinatrian.model.TempatModel
import arira.co.id.mesinatrian.ui.activity.main.MainActivity
import kotlinx.android.synthetic.main.activity_data.*
import kotlinx.android.synthetic.main.activity_pengaturan.*

class PengaturanActivity : BaseActivity() {

    var mTempat: TempatModel = TempatModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengaturan)
        setToolbar(getString(R.string.pengaturan))
        mTempat = pref.getData()
        
        pengaturan_edt_admin.setText(mTempat.admin)
        pengaturan_edt_kode.setText(mTempat.kodeAntrian)
        pengaturan_edt_loket.setText(mTempat.loket)
        pengaturan_edt_nomor.setText(mTempat.antrian)
        pengaturan_edt_tempat.setText(mTempat.tempat)
        
        pengaturan_switch.isChecked = mTempat.audio
        pengaturan_switch_layar.isChecked  = mTempat.layarOn

        pengaturan_div_reset.setOnClickListener {
            mTempat.antrian = "1"
            pref.setData(mTempat)

            this@PengaturanActivity.finish()
        }

        pengaturan_div_simpan.setOnClickListener {
            val loket = pengaturan_edt_loket.text.toString()
            val admin = pengaturan_edt_admin.text.toString()
            val tempat = pengaturan_edt_tempat.text.toString()
            val kode = pengaturan_edt_kode.text.toString()
            val antrian = pengaturan_edt_nomor.text.toString()
            if (loket.isEmpty()){
                toast.show(getString(R.string.lengkapi_data), this@PengaturanActivity)
            }else if (admin.isEmpty()){
                toast.show(getString(R.string.lengkapi_data), this@PengaturanActivity)
            }else if (tempat.isEmpty()){
                toast.show(getString(R.string.lengkapi_data), this@PengaturanActivity)
            }else if (antrian.isEmpty()){
                toast.show(getString(R.string.lengkapi_data), this@PengaturanActivity)
            }else{
                val mTempat  = TempatModel()
                mTempat.admin = admin
                mTempat.antrian = antrian
                mTempat.audio = pengaturan_switch.isChecked
                mTempat.layarOn = pengaturan_switch_layar.isChecked
                mTempat.loket = loket
                mTempat.tempat = tempat
                mTempat.kodeAntrian = kode

                pref.setData(mTempat)

                this@PengaturanActivity.finish()
            }
        }
    }
}