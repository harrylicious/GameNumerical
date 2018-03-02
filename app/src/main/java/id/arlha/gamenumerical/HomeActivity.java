package id.arlha.gamenumerical;


import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;


public class HomeActivity extends FragmentActivity {

    private int mShortAnimationDuration;

    ViewGroup container;
    TextView txtScore, txtScoreSalah, txtJumlahChild;
    Button btn;
    ProgressBar progress;
    int score = 0;
    int salah = 0;
    int a, b;
    int hasil;
    int count;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toast.makeText(getApplicationContext(), "Create" , Toast.LENGTH_SHORT).show();
        init();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils utils = new Utils();
               refresh();
                Toast.makeText(getApplicationContext(), Arrays.toString(utils.mData()), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Resume" , Toast.LENGTH_SHORT).show();
        txtJumlahChild.setText(String.valueOf(container.getChildCount()));
        if (container.getChildCount() <= 0) progress.setVisibility(View.VISIBLE);
        else progress.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Start" , Toast.LENGTH_SHORT).show();
        refresh();
        progress.setVisibility(View.INVISIBLE);
        txtJumlahChild.setText(String.valueOf(container.getChildCount()));
    }



    //region Initialize views
    void init() {
        container = findViewById(R.id.container);
        btn = findViewById(R.id.btnRefresh);
        txtScore = findViewById(R.id.txtNilaiScore);
        txtJumlahChild = findViewById(R.id.txtJumlahChild);
        progress = findViewById(R.id.progressbar);
    }

    void refresh() {
        for (int i = 0; i < 10; i++) {
            addItem(container);
        }
    }
    //endregion

    void addItem(final ViewGroup container) {
        final Button newButton = new Button(getApplicationContext());


        count = container.getChildCount() + 1;

        hasil = a + b;


        newButton.setBackground(getResources().getDrawable(R.drawable.layer_btn_orange));


        a = 1 + count;
        b = 10 - count;

        newButton.setText(String.format(getResources().getString(R.string.format), a, b, hasil));
        newButton.setBottom(5);


        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a + b == hasil) {
                    container.removeView(newButton);
                    salah++;
                } else {
                    newButton.setBackgroundColor(getResources().getColor(R.color.black));
                }
            }
        });
        count = container.getChildCount();
        score++;
        txtScore.setText(String.format(getResources().getString(R.string.scoreValue), score));
        container.addView(newButton);
    }


}


