package com.tiparo.tripway.utils

class ApiInvocationException(
    val errorCode: Int,
    val errorMessage: String?
) : Exception()