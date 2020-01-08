package com.takas125.recyclerviewsample.data.model

data class ParentModel (
    var title: String,
    var detail: String,
    val childList: List<ChildModel>,
    var expanded: Boolean = false
)
