package com.samsdk.mvparchexample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.samsdk.mvparchexample.model.Model
import com.samsdk.mvparchexample.presenter.Contract
import com.samsdk.mvparchexample.presenter.Presenter

class MainActivity : AppCompatActivity(), Contract.View {

    private var textView: TextView? = null
    private var button: Button? = null
    private var progressBar: ProgressBar? = null
    var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)
        presenter = Presenter(this, Model())


        this.button!!.setOnClickListener { presenter!!.onButtonClick() }

    }

    override fun showProgress() {
        progressBar?.isVisible = true
        textView?.isVisible = false
    }

    override fun hideProgress() {
        progressBar?.isVisible = false
        textView?.isVisible = true
    }

    override fun setString(string: String?) {
        textView?.text = string
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }
}