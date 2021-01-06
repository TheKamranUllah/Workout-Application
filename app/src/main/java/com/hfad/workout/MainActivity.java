package com.hfad.workout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        WorkoutDetailFragment fragment = (WorkoutDetailFragment)
//                    getSupportFragmentManager().findFragmentById(R.id.detail_frag);
//
//        fragment.setWorkout(1);
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);

        if (fragmentContainer != null)
        {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            androidx.fragment.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //getFragmentManager().beginTransaction();
            details.setWorkout(id);
            ft.replace(R.id.fragment_container, details);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        else
            {
                Intent intent = new Intent(this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int)id);
                startActivity(intent);
            }
    }
}
