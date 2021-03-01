package de.jonas.gymnasiumwuelfrath;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        final int state = this.getIntent().getExtras().getInt("state");

        final PDFView view = findViewById(R.id.pdf);

        switch (state) {
            case 1:
                view.fromUri(Uri.parse(
                    "https://gymnasium-wuelfrath.de/wp-content/uploads/2014/07/Plan-20_21-2.-HJ-SekI.pdf"
                )).load();
                break;

            case 2:
                view.fromUri(Uri.parse(
                    "https://gymnasium-wuelfrath.de/wp-content/uploads/2014/07/Plan-20_21-2.-HJ-SekII.pdf"
                )).load();
                break;

            default:
                break;
        }
    }
}