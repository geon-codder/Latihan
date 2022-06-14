package com.geco.latihan.data

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Data (
    val nama: String?,
    val alamat: String?,
    val ayang: String?,
    val judul: String?): Serializable

data class Data2 (
    val nama: String?,
    val alamat: String?,
    val ayang: String?,
    val judul: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeString(alamat)
        parcel.writeString(ayang)
        parcel.writeString(judul)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Data2> {
        override fun createFromParcel(parcel: Parcel): Data2 {
            return Data2(parcel)
        }

        override fun newArray(size: Int): Array<Data2?> {
            return arrayOfNulls(size)
        }
    }


}
