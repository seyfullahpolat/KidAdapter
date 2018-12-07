package com.link184.kidadapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.link184.kidadapter.simple.SimpleAdapter
import com.link184.kidadapter.simple.SimpleAdapterConfiguration
import com.link184.kidadapter.typed.MultiAdapterConfiguration
import com.link184.kidadapter.typed.MultiTypeAdapter

fun <T> RecyclerView.setUp(block: SimpleAdapterConfiguration<T>.() -> Unit): SimpleAdapter<T> {
    val configuration = SimpleAdapterConfiguration<T>().apply(block)
    return SimpleAdapter(configuration).apply {
        layoutManager = configuration.layoutManager ?: LinearLayoutManager(context)
        adapter = this
    }
}

fun RecyclerView.setUp(block: MultiAdapterConfiguration.() -> Unit): MultiTypeAdapter {
    val adapterDsl = MultiAdapterConfiguration().apply(block)
    return MultiTypeAdapter(adapterDsl).apply {
        layoutManager = adapterDsl.layoutManager ?: LinearLayoutManager(context)
        adapter = this
    }
}