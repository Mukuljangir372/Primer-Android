package com.mukul.jan.primer.flavor.full

import android.app.Activity
import android.content.Intent

class RootEntry(private val activity: Activity) {
    fun enter() {
        val intent = Intent(activity, FlavorActivity::class.java)
        activity.startActivity(intent)
    }
}