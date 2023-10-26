package com.example.torangscreensettings.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SettingsUiState(val id: String)

@HiltViewModel
class SettingsViewModel @Inject constructor(
    val useCase: SettingsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(SettingsUiState("")) // 뷰모델에 ID 빈값 지정
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            useCase.getId().collectLatest {
                it?.let {
                    _uiState.emit(
                        uiState.value.copy(id = it)
                    )
                }
            }
        }
    }
}