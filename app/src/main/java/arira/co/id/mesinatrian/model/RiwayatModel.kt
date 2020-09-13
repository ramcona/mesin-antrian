package arira.co.id.mesinatrian.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RiwayatModel() :Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

    @ColumnInfo(name = "loket")
    var loket:String = ""

    @ColumnInfo(name = "admin")
    var admin:String = ""

    @ColumnInfo(name = "nomorantri")
    var nomorantri:String = ""

    @ColumnInfo(name = "waktu")
    var waktu:String = ""

    @ColumnInfo(name = "tempat")
    var tempat:String = ""

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        loket = parcel.readString().toString()
        admin = parcel.readString().toString()
        nomorantri = parcel.readString().toString()
        waktu = parcel.readString().toString()
        tempat = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(loket)
        parcel.writeString(admin)
        parcel.writeString(nomorantri)
        parcel.writeString(waktu)
        parcel.writeString(tempat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RiwayatModel> {
        override fun createFromParcel(parcel: Parcel): RiwayatModel {
            return RiwayatModel(parcel)
        }

        override fun newArray(size: Int): Array<RiwayatModel?> {
            return arrayOfNulls(size)
        }
    }


}