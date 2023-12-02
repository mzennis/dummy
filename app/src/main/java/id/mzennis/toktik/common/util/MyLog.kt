package id.mzennis.toktik.common.util

import android.util.Log
import id.mzennis.toktik.MyApplication

fun logRefClass(clazz: Any) {
    Log.d(MyApplication::class.java.simpleName, "$clazz")
}