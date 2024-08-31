package com.kuxln.bankingapp.data.util

import java.security.MessageDigest

fun String.hashing(): String {
    return MessageDigest
        .getInstance("SHA-256")
        .digest(this.toByteArray())
        .fold("") { str, it -> str + "%02x".format(it) }
}