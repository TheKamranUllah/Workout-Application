package com.hfad.workout;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {

    static interface WorkoutListListener
    {
        void itemClicked(long id);
    }

    private WorkoutListListener Listener;

    public WorkoutListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//You must instantiate listView of ListFragment in onViewCreated because in onCreateView it will return null.
//Because it is created when view is created.
        ListView listView = getListView();
        listView.setBackgroundResource(R.drawable.workoutbg);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] names = new String[Workout.workouts.length];

        for (int i = 0; i < names.length; i++)
        {
            names[i] = Workout.workouts[i].getName();

        }
        CustomeListAdapter CustomAdapter = new CustomeListAdapter(getActivity(), names);
        setListAdapter(CustomAdapter);

//        ArrayAdapter<String>  MyAdapter = new ArrayAdapter<>(inflater.getContext(),
//                R.layout.listlayout, names);
//
//        setListAdapter(MyAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
//        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_workout_list, container, false);
    }

    @Override
    public ListView getListView() {
        return super.getListView();


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.Listener = (WorkoutListListener)getActivity();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


        if (Listener != null)
        {
            if (position == 0)
            {
                Toast.makeText(getContext(), "THIS IS NOT AN EXERCISE", Toast.LENGTH_SHORT).show();
            }
            else if (position == 13)
            {
                Toast.makeText(getContext(), "IT IS A CATEGORY CHOOSE FROM DAYS", Toast.LENGTH_SHORT).show();
            }else {
                Listener.itemClicked(id);
            }
        }
    }
}
