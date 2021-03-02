package de.jonas.gymnasiumwuelfrath;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PlansActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,
    View.OnClickListener {

    private Button sekI;
    private Button sekII;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans);

        this.sekI = findViewById(R.id.sekI);
        this.sekII = findViewById(R.id.sekII);

        final Toolbar toolbar = findViewById(R.id.toolbarPlan);
        toolbar.setTitle(Html.fromHtml(
            "<font color=#66626C>"
                + "Stundenpläne"
                + "</font>",
            Html.FROM_HTML_MODE_LEGACY
        ));
        setSupportActionBar(toolbar);

        sekI.setOnClickListener(this);
        sekII.setOnClickListener(this);

        final BottomNavigationView nav = findViewById(R.id.navPlan);
        nav.setSelectedItemId(R.id.plans);
        nav.setOnNavigationItemSelectedListener(this);
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

        if (id == R.id.homeNav) {
            finish();
            Intent home = new Intent(PlansActivity.this, MainActivity.class);
            startActivity(home);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
        return true;
    }

    @Override
    public void onClick(final View v) {
        if (v.equals(sekI)) {
            final Intent pdfI = new Intent(PlansActivity.this, PdfActivity.class);
            pdfI.putExtra("state", 0);
            startActivity(pdfI);
        }
        if (v.equals(sekII)) {
            final Intent pdfII = new Intent(PlansActivity.this, PdfActivity.class);
            pdfII.putExtra("state", 1);
            startActivity(pdfII);
        }
    }
}