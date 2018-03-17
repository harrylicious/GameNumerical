package id.arlha.gamenumerical;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import id.arlha.gamenumerical.Model.Data;

public class PlayActivity extends AppCompatActivity {

    ArrayList<Data> dataModels;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //Button btnAnim = findViewById(R.id.btn_anim);

    }

    void startAnimation(View v) {
        Animation falldown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_from_top);
        v.startAnimation(falldown);
    }


}