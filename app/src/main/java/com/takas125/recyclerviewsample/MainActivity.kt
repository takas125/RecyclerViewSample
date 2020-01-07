package com.takas125.recyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.takas125.recyclerviewsample.adapter.RecyclerViewAdapter
import com.takas125.recyclerviewsample.data.model.DetailItemModel
import com.takas125.recyclerviewsample.data.model.ItemModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var spinnerItems: MutableList<String>
    private var callCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList = createData()
        viewManager = LinearLayoutManager(this)
        viewAdapter = RecyclerViewAdapter(itemList)
        spinnerItems = createSpinnerData(itemList)

        val sppinerAdapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            spinnerItems
        )
        sppinerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        jump_spinner.adapter = sppinerAdapter

        recyclerView = this.itemRecyclerView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

        jump_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (++callCount > 1) {
                    itemList[position].expanded = true
                    recyclerView.scrollToPosition(position)
                    viewAdapter.notifyItemChanged(position)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
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

    private fun createSpinnerData (list: List<ItemModel>): MutableList<String> {
        var mutableList: MutableList<String> = mutableListOf()
        list.forEach {
            mutableList.add(it.title)
        }
        return mutableList
    }
}