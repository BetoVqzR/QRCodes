package com.example.qrcodes;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    private WebView wbV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);

        wbV = findViewById(R.id.wbV);
        WebSettings webSet = wbV.getSettings();
        webSet.setJavaScriptEnabled(true);
        wbV.loadUrl("//URL DE EL QR");
        wbV.getSettings().setAppCacheEnabled(true);
        wbV.getSettings().setAppCachePath("/data/data" + getPackageName() + "/cache");
        wbV.getSettings().setSaveFormData(true);
        wbV.getSettings().setDatabaseEnabled(true);
        wbV.getSettings().setDomStorageEnabled(true);
        wbV.setWebViewClient(new WebViewClient());
        CookieManager.getInstance().acceptCookie();
    }

    @Override
    public void onBackPressed() {
        if(wbV.canGoBack()){
            wbV.goBack();
        }
        else{
            super.onBackPressed();
        }


    }
}
