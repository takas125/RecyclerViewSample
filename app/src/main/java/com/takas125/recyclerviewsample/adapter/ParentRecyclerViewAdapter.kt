package com.takas125.recyclerviewsample.adapter

import android.animation.AnimatorInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.takas125.recyclerviewsample.R
import com.takas125.recyclerviewsample.data.model.ParentModel
import kotlinx.android.synthetic.main.parent_list_item.view.*

class ParentRecyclerViewAdapter (private val parentList: List<ParentModel>)
    : RecyclerView.Adapter<ParentRecyclerViewAdapter.ViewHolder>() {

    // ここで文字通り表示するお情報を保持している
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView
        val detailView: TextView
        val mainContentsArea: LinearLayout
        val childRecyclerView: RecyclerView

        init {
            titleView = itemView.item_title
            detailView = itemView.item_detail
            mainContentsArea = itemView.main_contents_area
            childRecyclerView = itemView.childRecyclerView
        }
    }

    val recyclerViewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.parent_list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    // ここでViewと紐づけている
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d(TAG, "Element $position set.")
        val parent: ParentModel = parentList[position]

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.titleView.text = parent.title
        viewHolder.detailView.text = parent.detail
        viewHolder.childRecyclerView.apply {
            adapter = ChildRecyclerViewAdapter(parent.childList)
            setRecycledViewPool(recyclerViewPool)
            visibility = if(parent.expanded) View.VISIBLE else View.GONE
        }

        viewHolder.mainContentsArea.setOnClickListener{
            val isExpand: Boolean = parent.expanded
            parent.expanded = !isExpand
            notifyItemChanged(position)
            AnimatorInflater.loadAnimator(it.context, R.animator.half_rotate_to_180).apply {
                setTarget(it.btnShowMore)
            }.start()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = parentList.size

    companion object {
        private val TAG = "ParentRecyclerViewAdapter"
    }
}
