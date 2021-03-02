package de.jonas.gymnasiumwuelfrath;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Main", Toast.LENGTH_SHORT);

        final Runnable runnable = () -> {
            finish();
            final Intent start = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(start);
            overridePendingTransition(R.anim.pull_in, R.anim.zoom_out);
        };
        new Handler(Looper.myLooper()).postDelayed(runnable, 1500);
    }
}