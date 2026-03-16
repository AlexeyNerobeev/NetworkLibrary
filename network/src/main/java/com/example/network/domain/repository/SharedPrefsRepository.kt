package com.example.network.domain.repository

import com.example.network.domain.model.ResponseAuth
import com.example.network.domain.model.User

interface SharedPrefsRepository {
    fun saveToken(responseAuth: ResponseAuth)
    fun loadToken(): String
    fun deleteToken()
    fun saveBucketId(id: String)
    fun loadBucketId(): String
    fun saveEmail(email: String)
    fun loadEmail(): String
    fun saveUserId(id: String)
    fun loadUserId(): String
}