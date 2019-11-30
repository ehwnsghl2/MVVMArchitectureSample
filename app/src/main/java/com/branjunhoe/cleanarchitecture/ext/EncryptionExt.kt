package com.branjunhoe.cleanarchitecture.ext

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.experimental.and

/**
 * SHA512 암호화
 * */
fun sha512Encryption(str: String): String {
    var md: MessageDigest? = null
    try {
        md = MessageDigest.getInstance("SHA-512")
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    val digest = md!!.digest(str.toByteArray())
    val sb = StringBuilder()
    for (i in digest.indices) {
        sb.append(
            ((digest[i] and 0xff.toByte()) + 0x100).toString(16).substring(1)
        )
    }
    return sb.toString()
}