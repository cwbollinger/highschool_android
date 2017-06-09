package com.ibm.GameOfLife;

import org.bollingers.GameOfLife.GridView;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		GridView gv = new GridView(this, 130, 60);
        setContentView(gv);
    }
}
