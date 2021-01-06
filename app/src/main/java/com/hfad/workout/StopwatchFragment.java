package com.hfad.workout;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment implements View.OnClickListener {

   private int seconds = 0;
   private boolean running;
   private boolean wasRunning;
   private Button Start, Stop, Reset;
    public StopwatchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null)
        {
         seconds = savedInstanceState.getInt("seconds");
         running = savedInstanceState.getBoolean("running");
         wasRunning = savedInstanceState.getBoolean("wasRunning");

         if (wasRunning)
         {
             running = true;
         }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
       runTimer(layout);

        Start = (Button) layout.findViewById(R.id.button_start);
        Stop =  (Button) layout.findViewById(R.id.button_stop);
        Reset = (Button) layout.findViewById(R.id.button_reset);

        Start.getBackground().setAlpha(75);
        Stop.getBackground().setAlpha(75);
        Reset.getBackground().setAlpha(75);

        //The below code is so important is onClick method won't work with fragment, so we setOnClickListener on our button
        // to avoid fatal exception if we don't the Android trys to call the method on that button in parent activity which cause fatal exception.
        Start.setOnClickListener(this);
        Stop.setOnClickListener(this);
        Reset.setOnClickListener(this);

        return  layout;
    }

    public void onClickStart(View view)
    {
        running = true;
    }

    public void onClickStop(View view)
    {
        running = false;
    }

    public void onClickReset(View view)
    {
        running = false;
        seconds = 0;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    public void onPause() {
        super.onPause();

        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (wasRunning)
        {
            running = true;
        }
    }

    private void runTimer(View view)
    {
      final TextView timeView = (TextView) view.findViewById(R.id.time_view);
      timeView.getBackground().setAlpha(70);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String Time = String.format("%d: %02d: %02d", hours, minutes,secs);

                timeView.setText(Time);
                if (running)
                {
                    seconds++;
                }

                handler.postDelayed(this, 1000);

            }
        });
    }

    @Override
    public void onClick(View view)
    {
   switch (view.getId())
   {
       case R.id.button_start:
           onClickStart(view);
           break;

       case R.id.button_stop:
           onClickStop(view);
           break;

       case R.id.button_reset:
           onClickReset(view);
           break;
   }
    }
}
