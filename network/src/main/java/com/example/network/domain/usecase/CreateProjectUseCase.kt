package com.example.network.domain.usecase

import com.example.network.domain.model.Project
import com.example.network.domain.model.RequestProject
import com.example.network.domain.repository.ProjectRepository

class CreateProjectUseCase(private val projectRepository: ProjectRepository) {
    suspend operator fun invoke(
        title: String,
        typeProject: String,
        user_id: String,
        dateStart: String,
        dateEnd: String,
        gender: String,
        description_source: String,
        category: String,
        image: String
    ): Project{
        return projectRepository.createProject(
            requestProject = RequestProject(
                title = title,
                typeProject = typeProject,
                user_id = user_id,
                dateStart = dateStart,
                dateEnd = dateEnd,
                gender = gender,
                description_source = description_source,
                category = category,
                image = image
            )
        )
    }
}