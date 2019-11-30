package com.branjunhoe.cleanarchitecture.ext

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresPermission
import org.jetbrains.anko.browse
import org.jsoup.Jsoup
import java.io.IOException


/**
 * Peppy 플레이 스토어 이동
 * */
fun Context.showPlayStore() {
    browse("market://details?id=$packageName")
}

/**
 * 앱 버전 이름 반환
 * */
fun Context.getVersionName(): String {
    var info: PackageInfo? = null
    try {
        info = packageManager.getPackageInfo(packageName, 0)
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }
    return info!!.versionName
}

/**
 * Peppy 마켓버전 이름 반환
 * */
fun Context.getMaketVersion(): String {
    val url = "https://play.google.com/store/apps/details?id=$packageName"
    try {
        val doc = Jsoup.connect(url).get()
        val currentVersionDiv = doc.select(".BgcNfc")
        val currentVersion = doc.select("div.hAyfc div span.htlgb")
        for (i in 0 until currentVersionDiv.size) {
            if (currentVersionDiv[i].text() == "Current Version") {
                return currentVersion[i].text()
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return null.toString()
}

/**
 * 네트워크 연결 상태 반환
 * */
@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.isNetworkStatusAvailable(): Boolean {
    val connectivityManager = this
        .getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    connectivityManager?.let {
        val netInfo = it.activeNetworkInfo
        netInfo?.let {
            if (netInfo.isConnected) return true
        }
    }
    return false
}

/**
 * 키보드 숨김
 * */
fun Context.hideKeyboard() {
    (getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(
        InputMethodManager.HIDE_IMPLICIT_ONLY,
        0
    )
}


