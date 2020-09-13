package arira.co.id.mesinatrian.database

import androidx.room.*
import arira.co.id.mesinatrian.model.RiwayatModel

@Dao
interface RiwayatDao {

    @Query("SELECT * FROM riwayatmodel ORDER BY id DESC")
    fun getAll(): List<RiwayatModel>

    @Insert
    fun insert(vararg riwayat: RiwayatModel)

}