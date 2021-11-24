package com.tinkoffhr

class EntityNotFoundException(override val message: String?) : Exception()

class InvalidArgumentException(override val message: String?) : Exception()