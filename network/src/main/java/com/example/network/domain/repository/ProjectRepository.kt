package com.example.network.domain.repository

import com.example.network.domain.model.Project
import com.example.network.domain.model.RequestProject
import com.example.network.domain.model.ResponsesProject

interface ProjectRepository {
    suspend fun getProjects(): ResponsesProject
    suspend fun createProject(requestProject: RequestProject): Project
}