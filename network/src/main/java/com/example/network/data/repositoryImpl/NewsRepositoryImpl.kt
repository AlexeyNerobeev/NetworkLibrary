package com.example.network.data.repositoryImpl

import com.example.network.data.dto.ResponsesNewsDto
import com.example.network.data.mappers.toModel
import com.example.network.data.utils.HttpConstants.GET_NEWS
import com.example.network.domain.model.ResponsesNews
import com.example.network.domain.repository.NewsRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NewsRepositoryImpl(
    private val httpClient: HttpClient
): NewsRepository {
    override suspend fun getNews(): ResponsesNews {
        return httpClient.get(GET_NEWS).body<ResponsesNewsDto>().toModel()
    }
}