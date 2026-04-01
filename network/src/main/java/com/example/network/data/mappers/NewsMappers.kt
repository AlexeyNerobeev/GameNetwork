package com.example.network.data.mappers

import com.example.network.data.dto.NewsDto
import com.example.network.data.dto.ResponsesNewsDto
import com.example.network.domain.model.News
import com.example.network.domain.model.ResponseNews

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

internal fun ResponseNews.toDto() = ResponsesNewsDto(
    page = page,
    perPage = perPage,
    totalPages = totalPages,
    totalItems = totalItems,
    items = items.map { it.toDto() }
)

internal fun ResponsesNewsDto.toModel() = ResponseNews(
    page = page,
    perPage = perPage,
    totalPages = totalPages,
    totalItems = totalItems,
    items = items.map { it.toModel() }
)