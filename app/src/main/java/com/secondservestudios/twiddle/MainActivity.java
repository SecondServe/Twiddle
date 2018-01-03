package com.secondservestudios.twiddle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button leftThumb;
    Button rightThumb;
    TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftThumb = (Button) findViewById(R.id.leftThumb);
        rightThumb = (Button) findViewById(R.id.rightThumb);
        

        rightThumb.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            public void onSwipeTop(){
                Toast.makeText(MainActivity.this, "right swiped up", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeBottom(){
                Toast.makeText(MainActivity.this, "right swiped down", Toast.LENGTH_SHORT).show();
            }

            
        });

        leftThumb.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            public void onSwipeTop(){
                Toast.makeText(MainActivity.this, "left swiped up", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeBottom(){
                Toast.makeText(MainActivity.this, "left swiped down", Toast.LENGTH_SHORT).show();
            }

        });





    }

}
