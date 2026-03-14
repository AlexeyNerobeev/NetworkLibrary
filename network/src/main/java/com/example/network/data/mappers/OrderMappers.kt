package com.example.network.data.mappers

import com.example.network.data.dto.RequestOrderDto
import com.example.network.data.dto.ResponseOrderDto
import com.example.network.domain.model.RequestOrder
import com.example.network.domain.model.ResponseOrder

internal fun RequestOrder.toDto() = RequestOrderDto(
    user_id = user_id,
    product_id = product_id,
    count = count
)

internal fun RequestOrderDto.toModel() = RequestOrder(
    user_id = user_id,
    product_id = product_id,
    count = count
)

internal fun ResponseOrder.toDto() = ResponseOrderDto(
    id = id,
    collectionId = collectionId,
    collectionName = collectionName,
    created = created,
    updated = updated,
    user_id = user_id,
    product_id = product_id,
    count = count
)

internal fun ResponseOrderDto.toModel() = ResponseOrder(
    id = id,
    collectionId = collectionId,
    collectionName = collectionName,
    created = created,
    updated = updated,
    user_id = user_id,
    product_id = product_id,
    count = count
)