package com.branjunhoe.cleanarchitecture.ext


import android.app.Activity
import android.app.Service
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


/**
 * 액티비티에서 프래그먼트로 전환
 * */
fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transact {
        replace(frameId, fragment)
        addToBackStack(null)
    }
}

/**
 * 액티비티에서 프래그먼트 추가
 * */
fun AppCompatActivity.addFragmentInActivity(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transact {
        add(frameId, fragment)
        addToBackStack(null)
    }
}

/**
 * 액티비티에서 프래그먼트 보이기
 * */
fun AppCompatActivity.showFragmentInActivity(fragment: Fragment) {
    val ft = supportFragmentManager.beginTransaction()
    ft.show(fragment)
    ft.commitAllowingStateLoss()
}

/**
 * 액티비티에서 프래그먼트 숨기기
 * */
fun AppCompatActivity.hideFragmentInActivity(fragment: Fragment) {
    val ft = supportFragmentManager.beginTransaction()
    ft.hide(fragment)
    ft.commitAllowingStateLoss()
}

/**
 * 토스트메세지 띄우기 (1초)
 * */
fun AppCompatActivity.showToast(msg: CharSequence) {
    Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
}

/**
 * 토스트메세지 띄우기 (2초)
 * */
fun AppCompatActivity.showLongToast(msg: CharSequence) {
    Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
}

/**
 * 액티비티 화면 전환
 * */
inline fun <reified T : Activity> Activity.startActivity() = startActivity(Intent(this, T::class.java))

/**
 * 액티비티 화면 전환 및 돌아올 때 데이터 받기
 * */
inline fun <reified T : Activity> Activity.startActivityForResult(requestCode: Int) =
    startActivityForResult(Intent(this, T::class.java), requestCode)

/**
 * 서비스(Background) 실행
 * */
inline fun <reified T : Service> Activity.startService() = startService(Intent(this, T::class.java))




