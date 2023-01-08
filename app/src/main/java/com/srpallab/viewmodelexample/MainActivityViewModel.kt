package com.srpallab.viewmodelexample

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    private var result: Int = 0

    init {
        result = startingTotal
    }

    fun addNumber(number: Int) {
        result += number
    }

    fun getNumber(): Int {
        return result
    }
}