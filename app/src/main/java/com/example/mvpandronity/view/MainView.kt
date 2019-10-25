package com.example.mvpandronity.view

import com.example.mvpandronity.model.ResponseKodePos

interface MainView {
    fun loading(isLoading: Boolean)
    fun success(data:List<ResponseKodePos>)
    fun error(message:String)
}