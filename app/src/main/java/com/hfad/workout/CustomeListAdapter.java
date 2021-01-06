package com.hfad.workout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomeListAdapter extends BaseAdapter{

   private Context mcontext;
   //there is no need to specify length of the list here, it will take from constructor.
    String[] mlist;
   private TextView mtextview;
   private TextView ltextview;

    public CustomeListAdapter(Context mcontext, String[] mlist )
    {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }

    @Override
    public int getCount()
    {

        return mlist.length;
    }

    @Override
    public Object getItem(int i)
    {
        return mlist[i];
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View view1 = View.inflate(mcontext, R.layout.category_item, null);
        mtextview = (TextView) view1.findViewById(R.id.bold_text);
        ltextview = (TextView) view1.findViewById(R.id.bold_text1);

        mtextview.getBackground().setAlpha(60);
        ltextview.getBackground().setAlpha(60);

        if (mlist[i].equals("WEEK WORKOUT"))
        {
            mtextview.setText(mlist[i]);

           // View.GONE will collapse the space that view occupies
            ltextview.setVisibility(View.GONE);
           // Toast.makeText(mcontext, "workout", Toast.LENGTH_SHORT).show();
        }
        else
        {
            ////View.INVISIBLE  will only hide the view space will still remain.
            //ltextview.setVisibility(View.INVISIBLE);
            ltextview.setText(mlist[i]);
             mtextview.setVisibility(View.GONE);
            //Toast.makeText(mcontext, "others", Toast.LENGTH_SHORT).show();
        }

//The below code was printing, last element of the array for as many times as the size of the array.
/*       for (int k = 0; k < mlist.length; k++)
       {
           if (mlist[k].equals("WEEK WORKOUT"))
           {
               mtextview.setText(mlist[k]);

               View.GONE will collapse the space that view occupies
               ltextview.setVisibility(View.GONE);
               Toast.makeText(mcontext, "13", Toast.LENGTH_SHORT).show();
           }
          else
              {
                   ////View.INVISIBLE  will only hide the view space will still remain.
                  //ltextview.setVisibility(View.INVISIBLE);
             ltextview.setText(mlist[k]);
            // mtextview.setVisibility(View.GONE);
                   Toast.makeText(mcontext, "if", Toast.LENGTH_SHORT).show();
       }
       }*/
        return view1;
    }
}
