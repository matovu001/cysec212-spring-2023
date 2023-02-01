package net.matrich.twoactivityapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";
    TextView mTextviewSecond;
    EditText mEditTextSecond;
    Button mButtonReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextviewSecond = findViewById(R.id.textview_second);
        mEditTextSecond = findViewById(R.id.edittext_second);
        mButtonReply = findViewById(R.id.button_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        mTextviewSecond.setText(message);

    }

    public void sendReply(View view) {

        String reply = mEditTextSecond.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}