package id.arlha.gamenumerical;


import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import id.arlha.gamenumerical.Math.SimpleQuiz;
import tyrantgit.explosionfield.ExplosionField;


public class HomeActivity extends FragmentActivity {

    //region Declaration Variables
    ExplosionField explode;
    SimpleQuiz quiz = new SimpleQuiz();
    GameReferences pref = new GameReferences();
    Button newButton;
    MediaPlayer mediaPlayer = new MediaPlayer();

    ViewGroup container;
    TextView txtScore, txtBestScore, txtJumlahChild;
    Button btn, save;
    ProgressBar progress;
    int correct = 0, inCorrect = 0;
    String first, mid, last;
    int a, b, c, score, bestScore, childCount;
    String[] arr = quiz.shuffleQuestions(quiz.mergeAndShuffleQuestion());
    //endregion

    //region onCreate()
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        retreiveFromSharedPreference();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });




    }
    //endregion

    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    //region onResume()
    @Override
    protected void onResume() {
        super.onResume();
        saveIntoSharedPreference();
    }
    //endregion

    //region onStart()
    @Override
    protected void onStart() {
        childCount = container.getChildCount();
        if (childCount <= 0) {
            refresh();
        }

        progress.setVisibility(View.INVISIBLE);
        super.onStart();
    }
    //endregion

    //region onDestroy()
    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
    }
    //endregion

    //region SharedPreference for Scoring
    void saveIntoSharedPreference() {
        score = Integer.parseInt(txtScore.getText().toString());
        bestScore = pref.getBestScore(getApplicationContext(), "best");
        if (score > bestScore) {
            bestScore = score;
            pref.setBestScore(getApplicationContext(), "best", bestScore);
            pref.setScore(getApplicationContext(), "score", bestScore);

            setSpinningAnimation(txtBestScore);
        }
        new Runnable() {
            @Override
            public void run() {

            }
        };
        txtBestScore.setText(String.valueOf(bestScore));

    }

    void retreiveFromSharedPreference() {
        bestScore = pref.getBestScore(getApplicationContext(), "best");
        score = pref.getBestScore(getApplicationContext(), "score");
        txtBestScore.setText(String.valueOf(bestScore));
        txtScore.setText(String.valueOf(score));
    }
    //endregion

    //region Initialize views
    void init() {
        container = findViewById(R.id.container);
        btn = findViewById(R.id.btnRefresh);
        txtScore = findViewById(R.id.txtValueScore);
        txtBestScore = findViewById(R.id.txtBestScore);
        //txtScoreSalah = findViewById(R.id.txt);
        progress = findViewById(R.id.progressbar);
    }


    //endregion

    //region Add Question into view dinamically
    void refresh() {
        childCount = container.getChildCount();


        for (int i = 0; i < (10 - childCount); i++) {
            newButton = new Button(getApplicationContext());
            //newButton.setId(i);

            newButton.setBackground(getResources().getDrawable(R.drawable.layer_btn_orange));
            newButton.setText(arr[i]);
            newButton.setContentDescription(arr[i]);
            newButton.setBottom(5);

            setFallDownAnimation(newButton);
            container.addView(newButton);

            newButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String txt = (String) v.getContentDescription();
                    if (txt.trim().length() == 9) {
                        first = (String) txt.subSequence(0,1);
                        mid = (String) txt.subSequence(4,5);
                        last = (String) txt.subSequence(8,9);
                    }
                    else {
                        first = (String) txt.subSequence(0,1);
                        mid = (String) txt.subSequence(4,5);
                        last = (String) txt.subSequence(8,10);
                    }

                    a = Integer.parseInt(first);
                    b = Integer.parseInt(mid);
                    c = Integer.parseInt(last);

                    //Toast.makeText(getApplicationContext(), v.getContentDescription(), Toast.LENGTH_SHORT).show();

                    if (a * b == c) {
                        setExplode(v);
                        container.removeView(v);
                        correct++;
                        txtScore.setText(String.format(getResources().getString(R.string.scoreValue), correct));
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ting);
                        mediaPlayer.start();
                    } else {
                        v.setBackground(getResources().getDrawable(R.drawable.layer_btn_black));
                        Boolean checkState = v.getBackground().equals(getResources().getDrawable(R.drawable.layer_btn_black));
                        if (!checkState) {
                            inCorrect++;
                            mediaPlayer.stop();
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tong);
                            mediaPlayer.start();
                        }
                        Toast.makeText(getApplicationContext(), checkState.toString(), Toast.LENGTH_SHORT).show();

                        //txtScoreSalah.setText(String.format(getResources().getString(R.string.scoreValue), inCorrect));
                    }
                    saveIntoSharedPreference();
                }
            });
        }

    }
    //endregion

    void setExplode(View v) {
        explode = ExplosionField.attach2Window(this);
        explode.explode(v);
    }

    void setFallDownAnimation(View v) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_from_top);
        v.startAnimation(animation);
    }

    void setSpinningAnimation(View v) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.hyperspace_jump);
        v.startAnimation(animation);
    }


}


