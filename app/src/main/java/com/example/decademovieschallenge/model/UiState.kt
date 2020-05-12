package com.example.decademovieschallenge.model

sealed class UiState<out T> {
    object LoadingState : UiState<Nothing>()
    data class SuccessState<out T>(val data: List<T>) : UiState<T>()
    data class ErrorState<out T>(val error: String) : UiState<T>()
}