package com.example.network.data.mappers

import com.example.network.data.dto.NewsDto
import com.example.network.data.dto.ResponsesNewsDto
import com.example.network.domain.model.News
import com.example.network.domain.model.ResponsesNews

internal fun News.toDto() = NewsDto(
    collectionId = collectionId,
    collectionName = collectionName,
    id = id,
    newsImage = newsImage,
    created = created,
    updated = updated
)

internal fun NewsDto.toModel() = News(
    collectionId = collectionId,
    collectionName = collectionName,
    id = id,
    newsImage = newsImage,
    created = created,
    updated = updated
)

internal fun ResponsesNews.toDto() = ResponsesNewsDto(
    items = items.map { it.toDto() }
)

internal fun ResponsesNewsDto.toModel() = ResponsesNews(
    items = items.map { it.toModel() }
)