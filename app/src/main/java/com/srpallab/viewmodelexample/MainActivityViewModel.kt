package com.srpallab.viewmodelexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    private var result = MutableLiveData<Int>()

    val totalData : LiveData<Int>
    get() = result

    init {
        result.value = startingTotal
    }

    fun addNumber(number: Int) {
       result.value =  result.value?.plus(number)
    }

}