package com.example.part2_ch1_webtoon

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class WebtoonWebViewClient(
    private val progressBar: ProgressBar,
    private val saveData: (String) -> Unit,
) : WebViewClient() {

    //https://comic.naver.com/webtoon/detail?titleId=183559&no=566
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        //
        if (request != null && request.url.toString().contains("comic.naver.com/webtoon/detail")) {
            saveData.invoke(request.url.toString())
        }
        // "https://comic.naver.com/webtoon/detail?titleId=183559&no=566"
        //
        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onPageFinished(view: WebView?, url: String?) {  // 페이지가 끝났을 때
        super.onPageFinished(view, url)

        progressBar.visibility = View.GONE  // progressBar.isVisible = false 도 된다.
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {  // 페이지가 시작했을 때
        super.onPageStarted(view, url, favicon)

        progressBar.visibility = View.VISIBLE
    }

    /*
    override fun onReceivedError(  // 페이지에 에러가 발생했을 때
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        super.onReceivedError(view, request, error)
    }*/
}