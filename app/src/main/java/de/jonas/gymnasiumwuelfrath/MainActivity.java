package de.jonas.gymnasiumwuelfrath;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(Html.fromHtml(
            "<font color=#66626C>"
                + "Gymnasium Wülfrath"
                + "</font>",
            Html.FROM_HTML_MODE_LEGACY
        ));
        setSupportActionBar(toolbar);

        web = findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient());
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.loadUrl("https://gymnasium-wuelfrath.de/");

        final BottomNavigationView nav = findViewById(R.id.nav);
        nav.setSelectedItemId(R.id.homeNav);
        nav.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (web.canGoBack()) {
            web.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull final MenuItem item) {
        final int id = item.getItemId();

        switch (id) {
            case R.id.logineo:
                Intent logineo = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sgw.logineo.de/"));
                startActivity(logineo);
                break;

            case R.id.online:
                Intent gw = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gymnasium-wuelfrath.de/"));
                startActivity(gw);
                break;

            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
        final int id = item.getItemId();

        if (id == R.id.plans) {
            finish();
            Intent plans = new Intent(MainActivity.this, PlansActivity.class);
            startActivity(plans);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        return true;
    }
}