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
    TextView scoreBoard;
    Random randomDirection = new Random();
    Random randomStart = new Random();
    ImageView rightArrow;
    ImageView leftArrow;
    int direction;
    int score;
    boolean gameEnd;

    public void startGame(View view) {
        gameEnd = false;
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
        scoreBoard = (TextView) findViewById(R.id.scoreBoard);

        leftThumb.setVisibility(View.VISIBLE);
        rightThumb.setVisibility(View.VISIBLE);
        leftArrow.setVisibility(View.INVISIBLE);
        rightArrow.setVisibility(View.INVISIBLE);


        rightThumb.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {
                if (direction == 2) {
                    Toast.makeText(MainActivity.this, "NOPE", Toast.LENGTH_SHORT).show();
                } else if (direction == 1) {
                    score++;
                    scoreBoard.setText("Score: " + Integer.toString(score));
                    rightThumb.setVisibility(View.INVISIBLE);
                    leftThumb.setVisibility(View.VISIBLE);
                    direction = randomDirection.nextInt(3 - 1) + 1;
                    rightArrow.setVisibility(View.INVISIBLE);

                    if (direction == 1) {
                        leftArrow.setVisibility(View.VISIBLE);
                        leftArrow.setImageResource(R.drawable.up_arrow);
                    } else {
                        leftArrow.setVisibility(View.VISIBLE);
                        leftArrow.setImageResource(R.drawable.down_arrow);
                    }
                }


            }

            public void onSwipeBottom() {
                if (direction == 1) {
                    Toast.makeText(MainActivity.this, "NOPE", Toast.LENGTH_SHORT).show();
                } else if (direction == 2) {
                    score++;
                    scoreBoard.setText("Score: " + Integer.toString(score));
                    rightThumb.setVisibility(View.INVISIBLE);
                    leftThumb.setVisibility(View.VISIBLE);
                    direction = randomDirection.nextInt(3 - 1) + 1;
                    rightArrow.setVisibility(View.INVISIBLE);

                    if (direction == 1) {
                        leftArrow.setVisibility(View.VISIBLE);
                        leftArrow.setImageResource(R.drawable.up_arrow);
                    } else {
                        leftArrow.setVisibility(View.VISIBLE);
                        leftArrow.setImageResource(R.drawable.down_arrow);
                    }
                }
            }


        });

        leftThumb.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {
                if (direction == 2) {
                    Toast.makeText(MainActivity.this, "NOPE", Toast.LENGTH_SHORT).show();
                } else if (direction == 1) {
                    score++;
                    scoreBoard.setText("Score: " + Integer.toString(score));

                    rightThumb.setVisibility(View.VISIBLE);
                    leftThumb.setVisibility(View.INVISIBLE);
                    direction = randomDirection.nextInt(3 - 1) + 1;
                    leftArrow.setVisibility(View.INVISIBLE);

                    if (direction == 1) {
                        rightArrow.setVisibility(View.VISIBLE);
                        rightArrow.setImageResource(R.drawable.up_arrow);
                    } else {
                        rightArrow.setVisibility(View.VISIBLE);
                        rightArrow.setImageResource(R.drawable.down_arrow);
                    }
                }
            }


            public void onSwipeBottom() {
                if (direction == 1) {
                    Toast.makeText(MainActivity.this, "NOPE", Toast.LENGTH_SHORT).show();
                } else if (direction == 2) {
                    score++;
                    scoreBoard.setText("Score: " + Integer.toString(score));

                    rightThumb.setVisibility(View.VISIBLE);
                    leftThumb.setVisibility(View.INVISIBLE);
                    direction = randomDirection.nextInt(3 - 1) + 1;
                    leftArrow.setVisibility(View.INVISIBLE);
                    if (direction == 1) {
                        rightArrow.setVisibility(View.VISIBLE);
                        rightArrow.setImageResource(R.drawable.up_arrow);
                    } else {
                        rightArrow.setVisibility(View.VISIBLE);
                        rightArrow.setImageResource(R.drawable.down_arrow);
                    }
                }
            }

        });

    }

    //1 is up 2 is down
    public void gameRoundStart() {
        Toast.makeText(this, "game on", Toast.LENGTH_SHORT).show();
        int startingSide = randomStart.nextInt(3 - 1) + 1;

        if (startingSide == 1) {
            leftThumb.setVisibility(View.VISIBLE);
            rightThumb.setVisibility(View.INVISIBLE);
            leftArrow.setVisibility(View.VISIBLE);
            direction = randomDirection.nextInt(3 - 1) + 1;

            if (direction == 1) {
                leftArrow.setImageResource(R.drawable.up_arrow);
            } else if (direction == 2) {
                leftArrow.setImageResource(R.drawable.down_arrow);
            }
        }

        if (startingSide == 2) {
            leftThumb.setVisibility(View.INVISIBLE);
            rightThumb.setVisibility(View.VISIBLE);
            rightArrow.setVisibility(View.VISIBLE);
            direction = randomDirection.nextInt(3 - 1) + 1;

            if (direction == 1) {
                rightArrow.setImageResource(R.drawable.up_arrow);
            } else if (direction == 2) {
                rightArrow.setImageResource(R.drawable.down_arrow);
            }
        }
    }


}
