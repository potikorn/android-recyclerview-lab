package com.example.potikorn.recyclerviewlab

import android.app.Notification
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.potikorn.recyclerviewlab.gridview.GridLayoutActivity
import com.example.potikorn.recyclerviewlab.staggered.StaggeredGridLayoutActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_simple_menu.view.*

class MainActivity : AppCompatActivity() {

    private val menuAdapter: MenuAdapter by lazy { MenuAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textMenu = mutableListOf(
            getString(R.string.grid_layout),
            getString(R.string.staggered_grid_layout)
        )
        rvSimpleMenu.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = menuAdapter.apply { submitList(textMenu) }
        }
    }

    class MenuAdapter : ListAdapter<String, RecyclerView.ViewHolder>(SimpleMenuListDiffCallback()) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return SimpleMenuViewHolder(parent.inflate(R.layout.item_simple_menu))
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            return (holder as SimpleMenuViewHolder).onBindData(getItem(position))
        }

        inner class SimpleMenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            fun onBindData(text: String) {
                itemView.apply {
                    tvMenu.apply {
                        this.text = text
                        setOnClickListener { onClickNavigationTo(adapterPosition) }
                    }
                }
            }

            private fun onClickNavigationTo(pos: Int) {
                var destinationIntent: Intent? = null
                when (pos) {
                    0 -> destinationIntent =
                        Intent(itemView.context, GridLayoutActivity::class.java)
                    1 -> destinationIntent =
                        Intent(itemView.context, StaggeredGridLayoutActivity::class.java)
                }
                destinationIntent?.let {
                    itemView.context.startActivity(it)
                }
            }
        }

        class SimpleMenuListDiffCallback : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(p0: String, p1: String): Boolean {
                return p0 == p1
            }

            override fun areContentsTheSame(p0: String, p1: String): Boolean {
                return p0 == p1
            }
        }
    }
}
