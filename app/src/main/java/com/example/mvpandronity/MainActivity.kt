package com.example.mvpandronity

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import com.example.mvpandronity.model.ResponseKodePos
import com.example.mvpandronity.prasenter.MainPrasenterMpl
import com.example.mvpandronity.view.MainView

class MainActivity : AppCompatActivity(), MainView {
    override fun success(data: List<ResponseKodePos>) {
        Toast.makeText(applicationContext,"Jumlah Data: ${data.size}",Toast.LENGTH_LONG).show()
    }

    override fun error(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    private var progressDialog: ProgressDialog? = null
    private var prasenter = MainPrasenterMpl(this)

    override fun loading(isLoading: Boolean) {
        if(isLoading){
            progressDialog = ProgressDialog(this)
            progressDialog?.setMessage("Menggambil data")
            progressDialog?.show()
        }else{
            progressDialog?.dismiss()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prasenter.getData()
    }
}
