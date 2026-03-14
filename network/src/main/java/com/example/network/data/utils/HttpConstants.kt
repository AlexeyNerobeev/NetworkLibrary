package com.example.network.data.utils

object HttpConstants {
    const val BASE_URL = "https://api.matule.ru/api/"
    const val REGISTER = "collections/users/records"
    const val LOGIN = "collections/users/auth-with-password"
    const val GET_USER = "collections/users/records/"
    const val DELETE_USER = "collections/_authOrigins/records/"
    const val GET_NEWS = "collections/news/records"
    const val GET_PRODUCTS = "collections/products/records"
    const val GET_PRODUCT_BY_ID = "collections/products/records/"
    const val CREATE_CART = "collections/cart/records"
    const val UPDATE_CART = "collections/cart/records/"
    const val CREATE_ORDER = "collections/orders/records"
    const val PROJECTS = "collections/project/records"
}