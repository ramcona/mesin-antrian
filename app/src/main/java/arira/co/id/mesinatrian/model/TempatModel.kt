package arira.co.id.mesinatrian.model

import android.os.Parcel
import android.os.Parcelable

class TempatModel() :Parcelable{
    var loket:String = ""
    var tempat:String = ""
    var antrian:String = ""
    var admin:String = ""
    var kodeAntrian:String = ""
    var tanggal:String = ""
    var audio:Boolean = true
    var layarOn:Boolean = true

    constructor(parcel: Parcel) : this() {
        loket = parcel.readString().toString()
        tempat = parcel.readString().toString()
        antrian = parcel.readString().toString()
        admin = parcel.readString().toString()
        kodeAntrian = parcel.readString().toString()
        tanggal = parcel.readString().toString()
        audio = parcel.readByte() != 0.toByte()
        layarOn = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(loket)
        parcel.writeString(tempat)
        parcel.writeString(antrian)
        parcel.writeString(admin)
        parcel.writeString(kodeAntrian)
        parcel.writeString(tanggal)
        parcel.writeByte(if (audio) 1 else 0)
        parcel.writeByte(if (layarOn) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TempatModel> {
        override fun createFromParcel(parcel: Parcel): TempatModel {
            return TempatModel(parcel)
        }

        override fun newArray(size: Int): Array<TempatModel?> {
            return arrayOfNulls(size)
        }
    }

}