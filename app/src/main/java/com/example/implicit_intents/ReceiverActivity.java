package com.example.implicit_intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        TextView uriTextView = findViewById(R.id.uri_textview);

        Uri uri = getIntent().getData();
        if (uri != null) {
            uriTextView.setText(uri.toString());
        } else {
            uriTextView.setText("Ni prejetega URI-ja.");
        }
    }

    public void goToActivity1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}