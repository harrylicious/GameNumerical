package id.arlha.gamenumerical;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Gentong on 15/03/2018.
 */

public class GameReferences {
    public final String SCORING = "myScore";
    int score, highScore;

    protected void setBestScore(Context context, String key, int score) {
        SharedPreferences pref = context.getSharedPreferences(SCORING, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();


        editor.putInt(key, score).apply();
    }

    protected int getBestScore(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences(SCORING, Context.MODE_PRIVATE);

        return pref.getInt(key, 0);
    }

    protected void setScore(Context context, String key, int score) {
        SharedPreferences pref = context.getSharedPreferences(SCORING, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();


        editor.putInt(key, score).apply();
    }

    protected int getScore(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences(SCORING, Context.MODE_PRIVATE);

        return pref.getInt(key, 0);
    }
}
