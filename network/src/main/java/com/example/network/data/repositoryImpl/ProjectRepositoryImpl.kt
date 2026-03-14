package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.ProjectDto
import com.example.network.data.dto.ResponsesProjectDto
import com.example.network.data.mappers.toDto
import com.example.network.data.mappers.toModel
import com.example.network.data.utils.HttpConstants
import com.example.network.domain.model.Project
import com.example.network.domain.model.RequestProject
import com.example.network.domain.model.ResponsesProject
import com.example.network.domain.repository.ProjectRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ProjectRepositoryImpl(
    private val httpClient: HttpClient
): ProjectRepository {
    override suspend fun getProjects(): ResponsesProject {
        val request = httpClient.get(HttpConstants.PROJECTS)
        Log.i("getProjects", request.status.toString())
        return request.body<ResponsesProjectDto>().toModel()
    }

    override suspend fun createProject(requestProject: RequestProject): Project {
        val request = httpClient.post(HttpConstants.PROJECTS) {
            contentType(ContentType.Application.Json)
            setBody(requestProject.toDto())
        }
        Log.i("createProject", request.status.toString())
        return request.body<ProjectDto>().toModel()
    }
}