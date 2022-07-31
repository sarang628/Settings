package com.example.torangscreensettings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.torang_core.repository.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel
@Inject
constructor(private val settingsRepository: SettingsRepository) :
    ViewModel() {
    fun logout() {
        viewModelScope.launch {
            settingsRepository.logout()
        }
    }
}
