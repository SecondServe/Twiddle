package com.secondservestudios.twiddle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button leftThumb;
    Button rightThumb;
    Button startButton;
    TextView timer;
    Random randomDirection = new Random();
    Random randomStart = new Random();
    ImageView rightArrow;
    ImageView leftArrow;
    int direction;
    int score;
    boolean gameEnd = false;

    public void startGame(View view){
        gameRoundStart();
        startButton.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rightArrow = (ImageView) findViewById(R.id.rightArrow);
        leftArrow = (ImageView) findViewById(R.id.leftArrow);
        leftThumb = (Button) findViewById(R.id.leftThumb);
        rightThumb = (Button) findViewById(R.id.rightThumb);
        startButton = (Button) findViewById(R.id.startButton);
        leftThumb.setVisibility(View.VISIBLE);
        rightThumb.setVisibility(View.VISIBLE);
        leftArrow.setVisibility(View.INVISIBLE);
        rightArrow.setVisibility(View.INVISIBLE);
        

        rightThumb.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            public void onSwipeTop(){

                Toast.makeText(MainActivity.this, "right swiped up", Toast.LENGTH_SHORT).show();
                if (direction == 1){
                    score ++;
                    rightThumb.setVisibility(View.INVISIBLE);
                    leftThumb.setVisibility(View.VISIBLE);
                    direction = randomDirection.nextInt(3-1)+1;

                }

            }

            public void onSwipeBottom(){
                Toast.makeText(MainActivity.this, "right swiped down", Toast.LENGTH_SHORT).show();
                if (direction == 2){
                    score ++;
                    rightThumb.setVisibility(View.INVISIBLE);
                    leftThumb.setVisibility(View.VISIBLE);
                    direction = randomDirection.nextInt(3-1)+1;

                }
            }

            
        });

        leftThumb.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            public void onSwipeTop(){
                Toast.makeText(MainActivity.this, "left swiped up", Toast.LENGTH_SHORT).show();
                if (direction == 1){
                    score ++;
                    rightThumb.setVisibility(View.VISIBLE);
                    leftThumb.setVisibility(View.INVISIBLE);
                    direction = randomDirection.nextInt(3-1)+1;

                }
            }

            public void onSwipeBottom(){
                Toast.makeText(MainActivity.this, "left swiped down", Toast.LENGTH_SHORT).show();
                if (direction == 2){
                    score ++;
                    rightThumb.setVisibility(View.VISIBLE);
                    leftThumb.setVisibility(View.INVISIBLE);
                    direction = randomDirection.nextInt(3-1)+1;

                }
            }

        });

    }
    public void gameRoundStart(){
        Toast.makeText(this, "game on", Toast.LENGTH_SHORT).show();
        int startingSide = randomStart.nextInt(3-1)+1;

        if (startingSide == 1){
            leftThumb.setVisibility(View.VISIBLE);
            rightThumb.setVisibility(View.INVISIBLE);
            direction = randomDirection.nextInt(3-1)+1;

        }

        if(startingSide == 2){
            leftThumb.setVisibility(View.INVISIBLE);
            rightThumb.setVisibility(View.VISIBLE);
            direction = randomDirection.nextInt(3-1)+1;

        }
    }

    public void


}
