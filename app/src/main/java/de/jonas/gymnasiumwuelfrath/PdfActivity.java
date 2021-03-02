package de.jonas.gymnasiumwuelfrath;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class PdfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        final WebView web = findViewById(R.id.webPDF);

        final int state = this.getIntent().getExtras().getInt("state");

        final String[] currentAddress = new String[] {
            "https://gymnasium-wuelfrath.de/wp-content/uploads/2014/07/Plan-20_21-2.-HJ-SekI.pdf/",
            "https://gymnasium-wuelfrath.de/wp-content/uploads/2014/07/Plan-20_21-2.-HJ-SekII.pdf/",
        };

        web.setWebViewClient(new WebViewClient());
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + currentAddress[state]);
    }
}