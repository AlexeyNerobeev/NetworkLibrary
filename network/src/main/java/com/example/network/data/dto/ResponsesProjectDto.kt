package com.example.network.data.dto

import com.example.network.domain.model.Project
import kotlinx.serialization.Serializable

@Serializable
data class ResponsesProjectDto(
    val page: Int,
    val perPage: Int,
    val totalPages: Int,
    val totalItems: Int,
    val items: List<ProjectDto>
)