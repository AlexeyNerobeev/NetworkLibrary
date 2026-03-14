package com.example.network.data.mappers

import com.example.network.data.dto.ProductDto
import com.example.network.data.dto.ProductItemDto
import com.example.network.data.dto.ResponseProductsDto
import com.example.network.domain.model.Product
import com.example.network.domain.model.ProductItem
import com.example.network.domain.model.ResponseProducts

internal fun ProductItem.toDto() = ProductItemDto(
    id = id,
    title = title,
    price = price,
    //typeCLoses = typeCLoses,
    type = type
)

internal fun ProductItemDto.toModel() = ProductItem(
    id = id,
    title = title,
    price = price,
    //typeCLoses = typeCLoses,
    type = type
)

internal fun ResponseProducts.toDto() = ResponseProductsDto(
    items = items.map { it.toDto() }
)

internal fun ResponseProductsDto.toModel() = ResponseProducts(
    items = items.map { it.toModel() }
)

internal fun Product.toDto() = ProductDto(
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

internal fun ProductDto.toModel() = Product(
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