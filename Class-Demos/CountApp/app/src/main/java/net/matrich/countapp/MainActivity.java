package net.matrich.countapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView mTextViewCount;
    private Button mButtonCount;
    private Button mButtonCountDown;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewCount = findViewById(R.id.textview_count);
        mButtonCount = findViewById(R.id.button_count);
        mButtonCountDown = findViewById(R.id.button_countdown);

        mButtonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: Button Up was clicked.");
                mCount++;
                mTextViewCount.setText(Integer.toString(mCount));

                Toast tmsg = Toast.makeText(getApplicationContext(), "Count Button pressed",
                        Toast.LENGTH_SHORT);
                tmsg.show();
            }
        });

        mButtonCountDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCount--;
                mTextViewCount.setText(Integer.toString(mCount));
            }
        });

    }

    public void showToast(View view) {

        Toast toast = Toast.makeText(this, "Count App", Toast.LENGTH_LONG);
        toast.show();

    }
}