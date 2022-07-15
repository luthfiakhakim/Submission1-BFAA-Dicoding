package com.dicoding.submission1_githubuserapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val username: String,
    val name: String,
    val location: String,
    val company: String,
    val repository: String,
    val follower: String,
    val following: String,
    val avatar: Int
): Parcelable
