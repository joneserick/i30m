package br.com.stefick.i30m.shared.extensions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

fun <T> Flow<T>.handleErrors(): Flow<T> = flow {
    try {
        collect { value -> emit(value) }
    } catch (e: Exception) {
    }
}