package com.example.network.domain.usecase

import com.example.network.domain.repository.SharedPrefsRepository

class SaveBucketIdUseCase(private val sharedPrefsRepository: SharedPrefsRepository) {
    operator fun invoke(bucketId: String){
        sharedPrefsRepository.saveBucketId(bucketId)
    }
}