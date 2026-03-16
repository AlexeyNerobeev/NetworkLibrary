package com.example.network.data.repositoryImpl

import android.content.Context
import androidx.core.content.edit
import com.example.network.data.mappers.toDto
import com.example.network.domain.model.ResponseAuth
import com.example.network.domain.repository.SharedPrefsRepository

class SharedPrefsRepositoryImpl(context: Context): SharedPrefsRepository {
    val sharedPreferences = context.getSharedPreferences("Token", Context.MODE_PRIVATE)
    override fun saveToken(responseAuth: ResponseAuth) {
        if(responseAuth.token.isNotEmpty()){
            sharedPreferences.edit{ putString("token", responseAuth.toDto().token)}
        }
    }

    override fun loadToken(): String {
        val token = sharedPreferences.getString("token", null)
        return if (token.isNullOrEmpty()){
            ""
        } else{
            token
        }
    }

    override fun deleteToken() {
        sharedPreferences.edit{ clear() }
    }

    override fun saveBucketId(id: String) {
        if(id.isNotEmpty()) {
            sharedPreferences.edit { putString("bucket_id", id) }
        }
    }

    override fun loadBucketId(): String {
        val bucketId = sharedPreferences.getString("bucket_id", null)
        return if(bucketId.isNullOrEmpty()){
            ""
        } else{
            bucketId
        }
    }

    override fun loadEmail(): String {
        val email = sharedPreferences.getString("email", null)
        return if(email.isNullOrEmpty()){
            ""
        } else{
            email
        }
    }

    override fun saveEmail(email: String) {
        if(email.isNotEmpty()){
            sharedPreferences.edit{ putString("email", email)}
        }
    }

    override fun loadUserId(): String {
        val id = sharedPreferences.getString("userID", null)
        return if(id.isNullOrEmpty()){
            ""
        } else{
            id
        }
    }

    override fun saveUserId(id: String) {
        if(id.isNotEmpty()){
            sharedPreferences.edit{putString("userID", id)}
        }
    }
}