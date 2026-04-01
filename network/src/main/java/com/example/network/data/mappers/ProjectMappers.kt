package com.example.network.data.mappers

import com.example.network.data.dto.ProjectDto
import com.example.network.data.dto.ResponsesProjectDto
import com.example.network.domain.model.Project
import com.example.network.domain.model.ResponsesProject

internal fun Project.toDto() = ProjectDto(
    id = id,
    collectionId = collectionId,
    collectionName = collectionName,
    created = created,
    updated = updated,
    title = title,
    dateStart = dateStart,
    dateEnd = dateEnd,
    gender = gender,
    description_source = description_source,
    category = category,
    image = image,
    user_id = user_id
)

internal fun ProjectDto.toModel() = Project(
    id = id,
    collectionId = collectionId,
    collectionName = collectionName,
    created = created,
    updated = updated,
    title = title,
    dateStart = dateStart,
    dateEnd = dateEnd,
    gender = gender,
    description_source = description_source,
    category = category,
    image = image,
    user_id = user_id
)

internal fun ResponsesProject.toDto() = ResponsesProjectDto(
    page = page,
    perPage = perPage,
    totalPages = totalPages,
    totalItems = totalItems,
    items = items.map { it.toDto() }
)

internal fun ResponsesProjectDto.toModel() = ResponsesProject(
    page = page,
    perPage = perPage,
    totalPages = totalPages,
    totalItems = totalItems,
    items = items.map { it.toModel() }
)