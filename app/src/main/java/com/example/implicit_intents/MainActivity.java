package com.example.implicit_intents;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText websiteEditText;
    private EditText locationEditText;
    private EditText shareEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Modra vrstica stanja (status bar)
        getWindow().setStatusBarColor(Color.parseColor("#4053B5"));

        // Naslov se spusti pod uro in baterijo
        View header = findViewById(R.id.textView);
        ViewCompat.setOnApplyWindowInsetsListener(header, (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            int extra = (int) (20 * getResources().getDisplayMetrics().density);
            v.setPadding(v.getPaddingLeft(), bars.top + extra,
                    v.getPaddingRight(), v.getPaddingBottom());
            return insets;
        });

        websiteEditText = findViewById(R.id.website_edittext);
        locationEditText = findViewById(R.id.location_edittext);
        shareEditText = findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {

        String url = websiteEditText.getText().toString().trim();

        if (url.isEmpty()) {
            Toast.makeText(this, "Vpiši spletni naslov!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }

        Uri webpage = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No application found!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void openLocation(View view) {

        String loc = locationEditText.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + Uri.encode(loc));

        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No map application found!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void shareText(View view) {

        String text = shareEditText.getText().toString();

        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setText(text)
                .startChooser();
    }
}