package com.example.potikorn.recyclerviewlab

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_simple_card.view.*
import java.util.*
import kotlin.properties.Delegates

class BaseAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: MutableList<SimpleModel> by Delegates.observable(mutableListOf()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            SimpleViewHolder(parent.inflate(R.layout.item_simple_card))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
            (holder as SimpleViewHolder).onBindData(items[position])

    inner class SimpleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBindData(simpleModel: SimpleModel) {
            itemView.tv.text = simpleModel.id.toString()
            itemView.tv.setBackgroundColor(simpleModel.colorId ?: 0)
            itemView.tv.layoutParams.height = getRandomIntInRange(600, 350)
        }

        protected fun getRandomIntInRange(max: Int, min: Int): Int {
            val random = Random()
            return random.nextInt(max - min + min) + min
        }
    }
}
