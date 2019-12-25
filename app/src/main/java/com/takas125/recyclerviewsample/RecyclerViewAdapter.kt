package com.takas125.recyclerviewsample

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.takas125.recyclerviewsample.model.ItemModel
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerViewAdapter (private val itemList: List<ItemModel>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView
        val detailView: TextView

        init {
            view.setOnClickListener{
                Log.d(TAG, "Element $adapterPosition clicked.")
            }
            titleView = itemView.item_title
            detailView = itemView.item_detail
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d(TAG, "Element $position set.")

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.titleView.text = itemList[position].title
        viewHolder.detailView.text = itemList[position].detail
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = itemList.size

    companion object {
        private val TAG = "RecyclerViewAdapter"
    }
}
