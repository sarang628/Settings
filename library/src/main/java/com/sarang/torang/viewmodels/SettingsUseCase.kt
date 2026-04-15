package com.sarang.torang.viewmodels

import kotlinx.coroutines.flow.Flow

interface SettingsUseCase {
    suspend fun getId(): Flow<String?>
    suspend fun logout()
}