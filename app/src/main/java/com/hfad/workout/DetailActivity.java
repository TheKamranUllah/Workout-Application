package com.hfad.workout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_WORKOUT_ID ="id";
    private Toolbar mtoolbar;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

          mtoolbar = (Toolbar) findViewById(R.id.detail_toolbar);
          setSupportActionBar(mtoolbar);
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);
          getSupportActionBar().setDisplayShowHomeEnabled(true);

  //the toolbar in xml is androidx and in below code we were trying to assign to widget which was creating error.
//        mtoolbar = (Toolbar)findViewById(R.id.detail_toolbar);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            setActionBar(mtoolbar);
//        }
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setDisplayShowHomeEnabled(true);
//        mtoolbar.setTitle("WorkOut");

        WorkoutDetailFragment workoutDetailFragment = (WorkoutDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        
        int workOutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        workoutDetailFragment.setWorkout(workOutId);
    }
}
