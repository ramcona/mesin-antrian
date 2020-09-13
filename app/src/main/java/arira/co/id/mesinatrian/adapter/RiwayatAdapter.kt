package arira.co.id.mesinatrian.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import arira.co.id.mesinatrian.R
import arira.co.id.mesinatrian.adapter.holder.DefaultHolder
import arira.co.id.mesinatrian.adapter.holder.RiwayatHolder
import arira.co.id.mesinatrian.model.DefaultModel
import arira.co.id.mesinatrian.model.RiwayatModel

class RiwayatAdapter(
    private var data: List<RiwayatModel>) : RecyclerView.Adapter<RiwayatHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_riwayat, parent, false)
        return RiwayatHolder(view)
    }

    override fun getItemCount(): Int {
        return  data.size
    }

    override fun onBindViewHolder(holder: RiwayatHolder, position: Int) {
        holder.setData(data[position])
    }
}