package com.takas125.recyclerviewsample.factory

import com.takas125.recyclerviewsample.data.model.ChildModel

object ChildDataFactory {

    private fun getTitle(n: Int) : String{
        return "現在" + n + "番目の子供"
    }

    private fun getDetail(n: Int) : String{
        return "現在" + n + "番目の子供の詳細"
    }

    fun getChildren(childCount: Int) : List<ChildModel>{
        val children = mutableListOf<ChildModel>()
        for (i in 1..childCount) {
            val child = ChildModel(getTitle(i), getDetail(i))
            children.add(child)
        }
        return children
    }
}