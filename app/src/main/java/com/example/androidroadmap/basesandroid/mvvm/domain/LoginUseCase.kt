package com.example.androidroadmap.basesandroid.mvvm.domain

import com.example.androidroadmap.basesandroid.mvvm.data.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) {

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }
}