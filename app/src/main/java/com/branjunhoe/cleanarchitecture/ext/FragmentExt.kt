package com.branjunhoe.cleanarchitecture.ext

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.branjunhoe.cleanarchitecture.ui.base.BaseActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * 프래그먼트 간 화면 전환
 * */
fun Fragment.replaceFragmentInFragment(fragment: Fragment, frameId: Int) {
    childFragmentManager.transact {
        replace(frameId, fragment)
        addToBackStack(null)
    }
}

/**
 * 프래그먼트에서 프래그먼트 추가
 * */
fun Fragment.addFragmentInFragment(fragment: Fragment, frameId: Int) {
    childFragmentManager.transact {
        add(frameId, fragment)
        addToBackStack(null)
    }
}

/**
 * 프래그먼트에서 프래그먼트 보이기
 * */
fun Fragment.showDialogFragmentInFragment(dialogFragment: DialogFragment) {
    dialogFragment.show(childFragmentManager, dialogFragment.tag)
}

/**
 * 프래그먼트에서 바텀시트 보이기
 * */
fun Fragment.showBottomSheetDialogFragmentInFragment(dialogFragment: BottomSheetDialogFragment) {
    dialogFragment.show(childFragmentManager, dialogFragment.tag)
}


/**
 * 프래그먼트에서 액티비티 화면 전환
 * */
inline fun <reified T : Activity> Fragment.startActivity() = startActivity(Intent(activity, T::class.java))

inline fun <reified T : Activity> Fragment.startActivityForResult(requestCode: Int) =
    startActivityForResult(Intent(activity, T::class.java), requestCode)

/**
 * 프래그먼트에서 키보드 숨기기
 * */
fun Fragment.hideKeyboard() {
   // (activity as? BaseActivity<*>)?.hideKeyboard()
}

/**
 * 프래그먼트에서 토스트 메시지 보이기 (1초)
 * */
fun Fragment.showToast(msg: CharSequence) {
    //(activity as? BaseActivity<*>)?.showToast(msg)
}

/**
 * 프래그먼트에서 토스트 메시지 보이기 (2초)
 * */
fun Fragment.showLongToast(msg: CharSequence) {
   // (activity as? BaseActivity<*>)?.showLongToast(msg)
}

/**
 * 프래그먼트 데이터 전달
 * */
inline fun <reified T : Fragment> FragmentManager.getFragment(args: Bundle? = null): Fragment {
    val clazz = T::class.java
    return findFragmentByTag(clazz.name) ?: return (clazz.getConstructor().newInstance() as T).apply {
        args?.let {
            it.classLoader = javaClass.classLoader
            arguments = args
        }
    }
}

