package com.example.clean_architecture.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.signin.Phone
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class LoginIdPasswordUiState(
    val phoneNumber: Phone = Phone.default(),
    val password: String = "",
)

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _phoneNumber = MutableStateFlow(Phone.default())
    private val _password = MutableStateFlow("")

    val loginIdPasswordUiState = combine(_phoneNumber, _password) { phoneNumber, password ->
        LoginIdPasswordUiState(phoneNumber, password)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = LoginIdPasswordUiState()
    )

    fun updatePhoneNumber(number: String) {
        _phoneNumber.value = _phoneNumber.value.copy(number = number)
    }

    fun updatePassword(password: String) {
        _password.value = password
    }

}