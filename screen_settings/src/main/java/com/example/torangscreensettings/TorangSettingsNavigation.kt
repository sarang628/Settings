package com.example.torangscreensettings

import com.example.torang_core.navigation.SettingsNavigation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class TorangSettingsNavigation {
    @Binds
    abstract fun torangSettingsNavigation(settingsNavigationImpl: SettingsNavigationImpl): SettingsNavigation
}