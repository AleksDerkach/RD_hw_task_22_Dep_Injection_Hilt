package com.example.task_21_hometask_depinj_hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        val listView: RecyclerView = findViewById(R.id.RecyclerView)
        val viewModel:MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.getData()

        viewModel.uiState.observe(this){uiState ->
            when(uiState) {
                is MyViewModel.UiState.Empty -> ""
                //is MyViewModel.UiState.Processing -> "Processing..."
                is MyViewModel.UiState.Result -> {
                    val myAdapter = MyRecycleViewAdapter(uiState.listHero!!, {})
                    listView.adapter = myAdapter
                    listView.layoutManager = LinearLayoutManager(this)
                }
                is MyViewModel.UiState.Error -> Log.e("Tag_viewModel", "Error")
            }
        }
    }
}