package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mEditTextWebsite;
    EditText mEditTextLocation;
    EditText mEditTextShareThis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextWebsite = findViewById(R.id.edittext_website);
        mEditTextLocation = findViewById(R.id.edittext_location);
        mEditTextShareThis = findViewById(R.id.edittext_share);
    }

    public void openWebsite(View view) {

        String url = mEditTextWebsite.getText().toString();

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);

    }

    public void openLocation(View view) {

        String location = mEditTextLocation.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + location);

        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        startActivity(intent);

    }

    public void shareThis(View view) {

            String text = mEditTextShareThis.getText().toString();
            String mimeType = "text/plain";

        ShareCompat.IntentBuilder.from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(text)
                .startChooser();
    }
}