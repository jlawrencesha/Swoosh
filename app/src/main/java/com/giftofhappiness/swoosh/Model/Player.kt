package com.giftofhappiness.swoosh.Model

import android.os.Parcel
import android.os.Parcelable

class Player(var league: String?, var skill: String?): Parcelable {

    //a parcelable is like a zip file for classes.
    // it can be passed around to various activities.
    constructor(parcel: Parcel) : this(
    //    parcel.readString(),
        parcel.readString(),
        parcel.readString()){

    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(league)
        parcel.writeString(skill)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }
}