package com.example.network.data.mappers

import com.example.network.data.dto.RequestCartDto
import com.example.network.data.dto.ResponseCartDto
import com.example.network.domain.model.RequestCart
import com.example.network.domain.model.ResponseCart

internal fun RequestCart.toDto() = RequestCartDto(
    user_id = user_id,
    product_id = product_id,
    count = count
)

internal fun RequestCartDto.toModel() = RequestCart(
    user_id = user_id,
    product_id = product_id,
    count = count
)

internal fun ResponseCart.toDto() = ResponseCartDto(
    id = id,
    collectionId = collectionId,
    collectionName = collectionName,
    created = created,
    updated = updated,
    user_id = user_id,
    product_id = product_id,
    count = count
)

internal fun ResponseCartDto.toModel() = ResponseCart(
    id = id,
    collectionId = collectionId,
    collectionName = collectionName,
    created = created,
    updated = updated,
    user_id = user_id,
    product_id = product_id,
    count = count
)