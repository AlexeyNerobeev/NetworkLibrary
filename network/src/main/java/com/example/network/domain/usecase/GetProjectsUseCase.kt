package com.example.network.domain.usecase

import com.example.network.domain.model.ResponsesProject
import com.example.network.domain.repository.ProjectRepository

class GetProjectsUseCase(private val projectRepository: ProjectRepository) {
    suspend operator fun invoke(): ResponsesProject {
        return projectRepository.getProjects()
    }
}