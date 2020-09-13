package arira.co.id.mesinatrian.database

import androidx.room.Database
import androidx.room.RoomDatabase
import arira.co.id.mesinatrian.model.RiwayatModel


@Database(entities = [RiwayatModel::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun riwayatDao(): RiwayatDao?
}