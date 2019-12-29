package com.takas125.recyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.takas125.recyclerviewsample.model.DetailItemModel
import com.takas125.recyclerviewsample.model.ItemModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = RecyclerViewAdapter(createData())

        recyclerView = this.itemRecyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }

    private fun createData (): List<ItemModel> {
        val dataList = mutableListOf<ItemModel>()
        for (i in 0..49) {

            val detailData = DetailItemModel(
                "中身のタイトルだよ",
                "中身の詳細だよ"
            )

            val data = ItemModel(
                "タイトル" + i + "だよ",
                "詳細" + i  + "個目だよ",
                    detailData
                )
                dataList.add(data)
            }
        return dataList
    }
}