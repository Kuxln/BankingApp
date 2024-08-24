package com.kuxln.bankingapp.data.util

import java.security.MessageDigest

fun String.getHash() : String {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    messageDigest.update(this.toByteArray())
    return messageDigest.digest().toString()
}