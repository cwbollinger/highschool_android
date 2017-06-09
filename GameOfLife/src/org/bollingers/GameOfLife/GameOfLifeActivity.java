package org.bollingers.GameOfLife;

import org.bollingers.GameOfLife.GridView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class GameOfLifeActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout l = new LinearLayout(this);
        GridView gv = new GridView(this, 130, 60);
        setContentView(gv);
    }
}