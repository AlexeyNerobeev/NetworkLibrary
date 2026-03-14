package com.example.network.domain.usecase

import com.example.network.domain.model.ResponsesNews
import com.example.network.domain.repository.NewsRepository

class GetNewsUseCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(): ResponsesNews{
        return newsRepository.getNews()
    }
}