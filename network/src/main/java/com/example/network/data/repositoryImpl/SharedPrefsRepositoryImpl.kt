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
            sharedPreferences.edit { putString("userID", responseAuth.toDto().record.id) }
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


    override fun getUserId(): String {
        val userId = sharedPreferences.getString("userID", null)
        return if(userId.isNullOrEmpty()){
            ""
        } else{
            userId
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
}