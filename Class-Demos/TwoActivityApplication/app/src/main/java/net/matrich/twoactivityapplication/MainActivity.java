package net.matrich.twoactivityapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 100;
    public static final String EXTRA_MESSAGE =
            "com.example.twoactivities.extra.MESSAGE";
    private EditText mEditTextMessage;
    TextView mTextviewMainReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextMessage = findViewById(R.id.edittext_main);
        mTextviewMainReply = findViewById(R.id.textview_main_reply);

    }

    public void launchSecondActivity(View view) {

        Log.d(TAG, "launchSecondActivity: Button clicked!");
        String message = mEditTextMessage.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mTextviewMainReply.setText(reply);
            }
        }

    }
}