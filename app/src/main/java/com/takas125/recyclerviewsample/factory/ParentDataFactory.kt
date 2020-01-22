package com.takas125.recyclerviewsample.factory

import com.takas125.recyclerviewsample.data.model.ParentModel
import kotlin.random.Random

object ParentDataFactory {

    private fun getTitle(random: Int) : String{
        return "現在" + random + "番目の親"
    }

    private fun getDetail(random: Int) : String{
        return "現在" + random + "番目の親の詳細"
    }

    fun getParents(count : Int) : List<ParentModel>{
        val parents = mutableListOf<ParentModel>()
        for (i in 1..count){
            val childCount = Random.nextInt(1,10)
            val parent = ParentModel(getTitle(i), getDetail(i),ChildDataFactory.getChildren(childCount))
            parents.add(parent)
        }
        return parents
    }
}