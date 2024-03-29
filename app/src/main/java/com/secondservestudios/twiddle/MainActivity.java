package com.secondservestudios.twiddle;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button leftThumb;
    Button rightThumb;
    Button startButton;
    TextView timer;
    TextView scoreBoard;
    TextView countDown;
    TextView highScore;
    TextView roundScore;
    Random randomDirection = new Random();
    Random randomStart = new Random();
    ImageView rightArrow;
    ImageView leftArrow;
    int direction;
    int score;
    int adCount = 4;
    private InterstitialAd mInterstitialAd;
    boolean gameEnd;
    boolean gameRunning;

    SharedPreferences sharedPreferences;

    public void startGame(View view){
        startButton.setVisibility(View.INVISIBLE);
        if(adCount >= 3) {
            adCount = 0;
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                //gameRoundStart();
            }
        }
        else{
            gameRoundStart();
        }

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
        highScore = (TextView) findViewById(R.id.highScore);
        roundScore = (TextView) findViewById(R.id.roundScore);
        MobileAds.initialize(this, "ca-app-pub-3597284556748948~6732499357");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        countDown = (TextView) findViewById(R.id.countDown);
        startButton.setClickable(false);


        leftThumb.setVisibility(View.INVISIBLE);
        rightThumb.setVisibility(View.INVISIBLE);
        leftArrow.setVisibility(View.INVISIBLE);
        rightArrow.setVisibility(View.INVISIBLE);

        sharedPreferences = this.getSharedPreferences("com.secondservestudios.twiddle", Context.MODE_PRIVATE);

        gameRunning = false;

        int currentHighScore = sharedPreferences.getInt("highScore", 0);
        highScore.setText("High Score: " + currentHighScore);


        rightThumb.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {

                if(gameRunning) {
                    if (direction == 2) {
                        Toast.makeText(MainActivity.this, "NOPE", Toast.LENGTH_SHORT).show();
                        score--;
                        scoreBoard.setText("Score: " + Integer.toString(score));
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


            }

            public void onSwipeBottom() {

                if(gameRunning) {
                    if (direction == 1) {
                        Toast.makeText(MainActivity.this, "NOPE", Toast.LENGTH_SHORT).show();
                        score--;
                        scoreBoard.setText("Score: " + Integer.toString(score));
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
            }


        });

        leftThumb.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {

                if(gameRunning) {
                    if (direction == 2) {
                        Toast.makeText(MainActivity.this, "NOPE", Toast.LENGTH_SHORT).show();
                        score--;
                        scoreBoard.setText("Score: " + Integer.toString(score));
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
            }

                        public void onSwipeBottom() {

                            if(gameRunning) {
                                if (direction == 1) {
                                    Toast.makeText(MainActivity.this, "NOPE", Toast.LENGTH_SHORT).show();
                                    score--;
                                    scoreBoard.setText("Score: " + Integer.toString(score));
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
                        }

                    });

                    mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            // Code to be executed when an ad finishes loading.

                            startButton.setClickable(true);
                        }

                        @Override
                        public void onAdFailedToLoad(int errorCode) {
                            // Code to be executed when an ad request fails.

                            startButton.setClickable(true);
                            gameRoundStart();
                        }

                        @Override
                        public void onAdOpened() {
                            // Code to be executed when the ad is displayed.
                        }

                        @Override
                        public void onAdLeftApplication() {
                            // Code to be executed when the user has left the app.
                        }

                        @Override
                        public void onAdClosed() {
                            // Code to be executed when when the interstitial ad is closed.
                            mInterstitialAd.loadAd(new AdRequest.Builder().build());
                            gameRoundStart();
                        }
                    });

                }


            public void gameRoundStart() {
                Toast.makeText(MainActivity.this, "game on", Toast.LENGTH_SHORT).show();
                int startingSide = randomStart.nextInt(3 - 1) + 1;
                gameRunning = true;
                roundScore.setVisibility(View.INVISIBLE);

                    new CountDownTimer(30000, 1000) {

                        public void onTick(long millisUntilFinished) {

                            //int counter = 0;
                            countDown.setText(millisUntilFinished / 1000 + " Sec");
                            //countDown.setText(String.valueOf(counter));
                            //counter++;
                        }

                        public void onFinish() {
                            //timer.setText("done!");
                            gameRoundEnd();
                        }
                    }.start();

                    if (startingSide == 1) {
                        leftThumb.setVisibility(View.VISIBLE);
                        rightThumb.setVisibility(View.INVISIBLE);
                        leftArrow.setVisibility(View.VISIBLE);
                        rightArrow.setVisibility(View.INVISIBLE);
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
                        leftArrow.setVisibility(View.INVISIBLE);
                        direction = randomDirection.nextInt(3 - 1) + 1;

                        if (direction == 1) {
                            rightArrow.setImageResource(R.drawable.up_arrow);
                        } else if (direction == 2) {
                            rightArrow.setImageResource(R.drawable.down_arrow);
                        }
                    }

            }

            public void gameRoundEnd() {
                adCount = adCount + 1;
                startButton.setVisibility(View.VISIBLE);
                roundScore.setVisibility(View.VISIBLE);
                int getHighScore = sharedPreferences.getInt("highScore", 0);
                if (score > getHighScore) {
                    sharedPreferences.edit().putInt("highScore", score).apply();
                    int newHighScore = sharedPreferences.getInt("highScore", 0);
                    highScore.setText("High Score: " + newHighScore);
                }

                gameRunning = false;
                roundScore.setText("You Scored: " + score);
                score = 0;
                scoreBoard.setText("Score: " + Integer.toString(score));
                startButton.setText("Play Again?");
                leftThumb.setVisibility(View.INVISIBLE);
                rightThumb.setVisibility(View.INVISIBLE);
                rightArrow.setVisibility(View.INVISIBLE);
                leftArrow.setVisibility(View.INVISIBLE);

            }


        }