package com.morethanheroic.monsterhunter;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class WebViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupGlobalCookieStorage();
        setupContentContainer();
        setupWebView();
    }

    private void setupGlobalCookieStorage() {
        CookieManager.setAcceptFileSchemeCookies(true);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    private void setupContentContainer() {
        setContentView(R.layout.activity_web_view);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
    }

    private void setupWebView() {
        final WebView webView = locateIndexWebView();

        setupWebViewCookieStorage(webView);
        setupWebViewSettings(webView);
        setupWebViewContent(webView);
    }

    private WebView locateIndexWebView() {
        return (WebView) findViewById(R.id.webview);
    }

    private void setupWebViewCookieStorage(final WebView webView) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }
    }

    private void setupWebViewSettings(final WebView webView) {
        final WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportZoom(false);
    }

    private void setupWebViewContent(final WebView webView) {
          webView.setWebViewClient(new MyAppWebViewClient());
          webView.loadUrl("http://immanuelcommando.com");
    }

}