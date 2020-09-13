package arira.co.id.mesinatrian.adapter.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import arira.co.id.mesinatrian.R
import arira.co.id.mesinatrian.helper.Helper
import arira.co.id.mesinatrian.helper.Helper.log
import arira.co.id.mesinatrian.model.RiwayatModel

class RiwayatHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvAntrian :TextView = itemView.findViewById(R.id.iRiwayat_tv_antrian)
    val tvWatktu :TextView = itemView.findViewById(R.id.iRiwayat_tv_waktu)
    val tvTempat :TextView = itemView.findViewById(R.id.iRiwayat_tv_lokasi)
    val tvLoket :TextView = itemView.findViewById(R.id.iRiwayat_tv_loket)

    fun setData(model: RiwayatModel){
        tvAntrian.text = model.nomorantri
        tvLoket.text = itemView.context.getString(R.string.loket_, model.loket)
        tvTempat.text = """${model.admin} - ${model.tempat}"""
        tvWatktu.text = model.waktu

    }

}