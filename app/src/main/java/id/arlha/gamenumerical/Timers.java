package id.arlha.gamenumerical;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

/**
 * Created by Gentong on 19/03/2018.
 */

public class Timers extends AppCompatActivity {

    public int seconds = 60;
    public int minutes = 10;

    protected void set1Second(View v) {

        //Declare the timer
        Timer t = new Timer();
        //Set the schedule function and rate
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        TextView tv = (TextView) findViewById(R.id.txtBestScore);
                        tv.setText(String.valueOf(minutes)+":"+String.valueOf(seconds));
                        seconds -= 1;

                        if(seconds == 0)
                        {
                            tv.setText(String.valueOf(minutes)+":"+String.valueOf(seconds));

                            seconds=60;
                            minutes=minutes-1;

                        }



                    }

                });
            }

        }, 0, 1000);
    }
}
