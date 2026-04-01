package com.example.network.data.mappers

import com.example.network.data.dto.ProductItemDto
import com.example.network.data.dto.ProductsDto
import com.example.network.data.dto.ResponseProductsDto
import com.example.network.domain.model.Product
import com.example.network.domain.model.ProductItem
import com.example.network.domain.model.ResponseProducts

internal fun ProductItem.toDto() = ProductItemDto(
    id = id,
    title = title,
    price = price,
    typeCloses = typeCloses,
    type = type
)

internal fun ProductItemDto.toModel() = ProductItem(
    id = id,
    title = title,
    price = price,
    typeCloses = typeCloses,
    type = type
)

internal fun ResponseProducts.toDto() = ResponseProductsDto(
    page = page,
    perPage = perPage,
    totalPages = totalPages,
    totalItems = totalItems,
    items = items.map { it.toDto() }
)

internal fun ResponseProductsDto.toModel() = ResponseProducts(
    page = page,
    perPage = perPage,
    totalPages = totalPages,
    totalItems = totalItems,
    items = items.map { it.toModel() }
)

internal fun Product.toDto() = ProductsDto(
    id = id,
    collectionId = collectionId,
    collectionName = collectionName,
    created = created,
    updated = updated,
    title = title,
    description = description,
    price = price,
    typeCloses = typeCloses,
    type = type,
    approximateCost = approximateCost
)

internal fun ProductsDto.toModel() = Product(
    id = id,
    collectionId = collectionId,
    collectionName = collectionName,
    created = created,
    updated = updated,
    title = title,
    description = description,
    price = price,
    typeCloses = typeCloses,
    type = type,
    approximateCost = approximateCost
)