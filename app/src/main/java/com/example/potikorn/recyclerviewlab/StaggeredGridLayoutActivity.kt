package com.example.potikorn.recyclerviewlab

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_staggered_grid_layout.*

class StaggeredGridLayoutActivity : AppCompatActivity() {

    private val simpleAdapter: BaseAdapter by lazy { BaseAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staggered_grid_layout)
        rvStaggeredList.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = simpleAdapter
        }

        val listSimpleModel = (0 until 30).map { SimpleModel(it + 1, randomColor()) }.toMutableList()
        simpleAdapter.items = listSimpleModel
    }
}
