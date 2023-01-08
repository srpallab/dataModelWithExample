package com.srpallab.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.srpallab.viewmodelexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        viewModelFactory = MainActivityViewModelFactory(125)
        viewModel = ViewModelProvider(
            this, viewModelFactory
        )[MainActivityViewModel::class.java]

        binding.tvResult.text = viewModel.getNumber().toString()

        binding.btnAdd.setOnClickListener {
            if(binding.etNumber.text.isNotEmpty()){
                val numberToAdd: String = binding.etNumber.text.toString()
                viewModel.addNumber(numberToAdd.toInt())
                binding.tvResult.text = viewModel.getNumber().toString()
            } else{
                Toast.makeText(
                    this, "Please Give a Number", Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}