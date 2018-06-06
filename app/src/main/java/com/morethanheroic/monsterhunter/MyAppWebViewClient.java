package com.morethanheroic.monsterhunter;
import android.webkit.WebViewClient;
import android.webkit.WebView;
import android.net.Uri;
import android.content.Intent;


public class MyAppWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(Uri.parse(url).getHost().endsWith("immanuelcommando.com")) {
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}