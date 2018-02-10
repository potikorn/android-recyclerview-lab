package com.example.potikorn.recyclerviewlab

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*


fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun randomColor(): Int {
    val rnd = Random()
    return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
}