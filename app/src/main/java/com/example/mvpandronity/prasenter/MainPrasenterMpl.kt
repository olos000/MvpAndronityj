package com.example.mvpandronity.prasenter

import com.example.mvpandronity.data.ApiCall
import com.example.mvpandronity.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPrasenterMpl (private val  view:MainView) : MainPrasenter {
    override fun getData(){
        view.loading(true)
       ApiCall().instance().getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                view.loading(false)
                if (it.body()!!.isNotEmpty()){
                    view.success(it.body()!!)
                }else{
                    view.error("Data tidak tersedia")
                }
            },{
                view.loading(false)
                view.error(it.message!!)
            })
    }

}

