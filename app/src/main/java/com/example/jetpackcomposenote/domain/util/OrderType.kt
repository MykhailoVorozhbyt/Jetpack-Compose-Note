package com.example.jetpackcomposenote.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
