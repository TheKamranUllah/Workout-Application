package com.hfad.workout;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

/**
 * A simple {@link Fragment} subclass.
 */

public class WorkoutDetailFragment extends Fragment {

    private long workoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState != null)
        {
            workoutId = savedInstanceState.getLong("WorkOutId");
        }
        else
            {
                androidx.fragment.app.FragmentTransaction  fragmentTransaction = getChildFragmentManager().beginTransaction();
                StopwatchFragment stopwatchFragment = new StopwatchFragment();
                fragmentTransaction.replace(R.id.stop_watch_container, stopwatchFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();
            }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putLong("WorkOutId", workoutId);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();
        if (view != null)
        {
            TextView Title = (TextView) view.findViewById(R.id.text_title);
            //pa di landi code had dy yra, transparent kawalo dapara
            //setAlpha(45) it is percentage of more than 100 increase and decreasing will cause changes.
            Title.getBackground().setAlpha(85);
            Workout workout =  Workout.workouts[ (int) workoutId];
            Title.setText(workout.getName());

            TextView Description = (TextView) view.findViewById(R.id.description);
            Description.getBackground().setAlpha(85);
            Description.setText(workout.getDescription());
        }
    }

    public void setWorkout(long workout) {
        this.workoutId = workout;
    }
}
