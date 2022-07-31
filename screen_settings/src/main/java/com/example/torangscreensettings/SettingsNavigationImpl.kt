package com.example.torangscreensettings

import android.content.Context
import android.content.Intent
import com.example.torang_core.navigation.SettingsNavigation
import javax.inject.Inject

class SettingsNavigationImpl @Inject constructor() : SettingsNavigation {
    override fun goSettings(context: Context) {
        context.startActivity(Intent(context, SettingsActivity::class.java))
    }
}