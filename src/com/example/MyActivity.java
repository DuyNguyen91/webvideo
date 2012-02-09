package com.example;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class MyActivity extends Activity
{

    private LinearLayout ll;
    private WebView webview2;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ll = (LinearLayout) findViewById(R.id.container);
        //showVideo(" http://player.ooyala.com/player.js?width=640&height=360&embedCode=Jic24xMjrCCEDfEzRtVI7Cl8PfWm6dU0");
        showVideo1();
    }

    @Override
    protected void onPause() {
        super.onPause();    //To change body of overridden methods use File | Settings | File Templates.
        webview2.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();    //To change body of overridden methods use File | Settings | File Templates.
        webview2.onResume();
    }

    @Override
    protected void onDestroy() {

        webview2.onPause();
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
         super.onConfigurationChanged(newConfig);
    }

    public void showVideo(String url){
        webview2 = new WebView(this);
        webview2.setId(1);
        webview2.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        webview2.getSettings().setJavaScriptEnabled(true);
        webview2.getSettings().setLoadWithOverviewMode(true);
        webview2.getSettings().setUseWideViewPort(true);
        webview2.setWebViewClient(new mWebViewClient());
        webview2.getSettings().setPluginsEnabled(true);
        webview2.getSettings().setUserAgentString("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.36 (KHTML, like Gecko) Chrome/13.0.766.0 Safari/534.36");


        webview2.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                1f));


        if (url.contains(".js")) {

            String data = "<iframe class=\"youtube-player\" type=\"text/html\" width=\"640\" height=\"385\" src=\"http://www.youtube.com/embed/bIPcobKMB94\" frameborder=\"0\">\n" +
                    "</iframe>\n" +
                    "";
            webview2.loadDataWithBaseURL("fake://fake.com", data,
                    "text/html", "UTF-8", null);
        } else {
            webview2.loadUrl(url);
        }

        ll.addView(webview2, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void showVideo1(){
        webview2 = new WebView(this);
        webview2.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        webview2.getSettings().setJavaScriptEnabled(true);
        webview2.getSettings().setLoadWithOverviewMode(true);
        webview2.getSettings().setUseWideViewPort(true);
        webview2.setWebViewClient(new mWebViewClient());
        webview2.getSettings().setPluginsEnabled(true);
        webview2.getSettings().setUserAgentString("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.36 (KHTML, like Gecko) Chrome/13.0.766.0 Safari/534.36");


        webview2.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                1f));



            String js = "<script  type='text/javascript'> function pauseVideo() {" +
                    "var myVideo = document.getElementsByTagName('video')[0];" +
                    "myVideo.pause();" +
                    "}" +
                    "function playVideo() {" +
                    "var myVideo = document.getElementsByTagName('video')[0];" +
                    " myVideo.play();" +
                    "} " +
                    "</script> " +
                    "<script src=\"http://player.ooyala.com/player.js?width=640&height=360&embedCode=Jic24xMjrCCEDfEzRtVI7Cl8PfWm6dU0&width=450.000000&height=188.000000&autoplay=1\"></script>";

            webview2.loadDataWithBaseURL("fake://fake.com", js,
                    "text/html", "UTF-8", null);


        ll.addView(webview2, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    private class mWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }

}
