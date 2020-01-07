package com.takas125.recyclerviewsample.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.takas125.recyclerviewsample.R
import com.takas125.recyclerviewsample.data.model.ItemModel
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerViewAdapter (private val itemList: List<ItemModel>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    // ここで文字通り表示するお情報を保持している
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView
        val detailView: TextView
        val includeTitleView: TextView
        val includeDetailView: TextView
        val mainContentsArea: LinearLayout
        val includeContentsArea: LinearLayout

        init {
            view.setOnClickListener{
                Log.d(TAG, "Element $adapterPosition clicked.")
            }
            titleView = itemView.item_title
            detailView = itemView.item_detail
            includeTitleView = itemView.include_item_title
            includeDetailView = itemView.include_item_detail
            mainContentsArea = itemView.main_contents_area
            includeContentsArea = itemView.detail_contents_area
        }

//        fun bind (item: ItemModel) {
//
//        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    // ここでViewと紐づけている
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d(TAG, "Element $position set.")
        val item: ItemModel = itemList[position]

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.titleView.text = item.title
        viewHolder.detailView.text = item.detail
        viewHolder.includeTitleView.text = item.detailItem.title
        viewHolder.includeDetailView.text = item.detailItem.detail

        viewHolder.mainContentsArea.setOnClickListener{
            val isExpand: Boolean = item.expanded
            item.expanded = !isExpand
            notifyItemChanged(position)
        }
        viewHolder.includeContentsArea.visibility = if(item.expanded) View.VISIBLE else View.GONE
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = itemList.size

    companion object {
        private val TAG = "RecyclerViewAdapter"
    }
}
