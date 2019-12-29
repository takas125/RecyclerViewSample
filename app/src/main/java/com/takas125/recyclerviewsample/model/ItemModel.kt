package com.takas125.recyclerviewsample.model

data class ItemModel (
    var title: String,
    var detail: String,
    val detailItem: DetailItemModel,
    var expanded: Boolean = false
)
