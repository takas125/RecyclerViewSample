package com.takas125.recyclerviewsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.takas125.recyclerviewsample.R
import com.takas125.recyclerviewsample.data.model.ChildModel
import kotlinx.android.synthetic.main.child_list_item.view.*

class ChildRecyclerViewAdapter (private val childList: List<ChildModel>)
    : RecyclerView.Adapter<ChildRecyclerViewAdapter.ViewHolder>() {

    // ここで文字通り表示するお情報を保持している
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.include_item_title
        val detailView: TextView = view.include_item_detail
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.child_list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    // ここでViewと紐づけている
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val child: ChildModel = childList[position]

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.titleView.text = child.title
        viewHolder.detailView.text = child.detail
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = childList.size
}
