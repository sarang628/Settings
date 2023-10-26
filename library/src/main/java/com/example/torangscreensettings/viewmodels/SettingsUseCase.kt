package com.example.torangscreensettings.viewmodels

import kotlinx.coroutines.flow.Flow

interface SettingsUseCase {
    suspend fun getId(): Flow<String?>
}