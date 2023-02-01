package net.matrich.dicerollerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int rollResult = 1;
    ImageView mImageviewDice;
    TextView mTextViewRoll;
    Button mButtonRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageviewDice = findViewById(R.id.imageview_dice);
        mTextViewRoll = findViewById(R.id.textview_roll);
        mButtonRoll = findViewById(R.id.button_roll);
    }

    public void rollDice(View view) {

        rollResult = new Random().nextInt(6) + 1;
        mTextViewRoll.setText(Integer.toString(rollResult));

        switch (rollResult) {
            case 1:
                mImageviewDice.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                mImageviewDice.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                mImageviewDice.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                mImageviewDice.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                mImageviewDice.setImageResource(R.drawable.dice_5);
                break;
            default:
                mImageviewDice.setImageResource(R.drawable.dice_6);

        }

    }
}