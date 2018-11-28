package com.example.potikorn.recyclerviewlab.gridview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.example.potikorn.recyclerviewlab.BaseAdapter
import com.example.potikorn.recyclerviewlab.R
import com.example.potikorn.recyclerviewlab.SimpleModel
import com.example.potikorn.recyclerviewlab.SpacesItemDecoration
import com.example.potikorn.recyclerviewlab.randomColor
import kotlinx.android.synthetic.main.activity_staggered_grid_layout.*

class GridLayoutActivity : AppCompatActivity() {

    private val simpleAdapter: BaseAdapter by lazy { BaseAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staggered_grid_layout)
        rvSimpleList.apply {
            layoutManager = GridLayoutManager(this@GridLayoutActivity,
                    2, GridLayoutManager.VERTICAL, false)
            addItemDecoration(SpacesItemDecoration(16))
            adapter = simpleAdapter
        }

        val listSimpleModel = (0 until 30).map {
            SimpleModel(
                it + 1,
                randomColor()
            )
        }.toMutableList()
        simpleAdapter.items = listSimpleModel
    }

}