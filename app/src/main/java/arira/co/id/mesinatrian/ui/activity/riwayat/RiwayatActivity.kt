package arira.co.id.mesinatrian.ui.activity.riwayat

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import arira.co.id.mesinatrian.R
import arira.co.id.mesinatrian.adapter.RiwayatAdapter
import arira.co.id.mesinatrian.app.App.Companion.db
import arira.co.id.mesinatrian.helper.BaseActivity
import kotlinx.android.synthetic.main.activity_riwayat.*

class RiwayatActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat)
        setToolbar(getString(R.string.riwayat))
        val list = db?.riwayatDao()?.getAll() ?: ArrayList()

        if (list.size > 0){
            riwayat_div_kosong.visibility = View.GONE
            riwayat_rv_data.layoutManager  = LinearLayoutManager(this)
            riwayat_rv_data.adapter = RiwayatAdapter(list)
        }else{
            riwayat_div_kosong.visibility = View.VISIBLE
        }
    }
}