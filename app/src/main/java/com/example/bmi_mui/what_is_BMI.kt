package com.example.bmi_mui

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.bmi_mui.databinding.ActivityWhatIsBmiBinding

class what_is_BMI : AppCompatActivity() {
    private lateinit var binding: ActivityWhatIsBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhatIsBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webview.webViewClient = MyWebViewClient()
        binding.webview.loadUrl("https://en.wikipedia.org/wiki/Body_mass_index")

    }
    inner class MyWebViewClient :WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            binding.progressBar.visibility = View.GONE
        }
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            Log.d("TAG", "shouldOverrideUrlLoading: "+request?.url)
            return super.shouldOverrideUrlLoading(view, request)

        }


    }
}


