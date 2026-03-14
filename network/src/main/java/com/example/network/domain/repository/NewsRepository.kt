package com.example.network.domain.repository

import com.example.network.domain.model.ResponsesNews

interface NewsRepository {
    suspend fun getNews(): ResponsesNews
}