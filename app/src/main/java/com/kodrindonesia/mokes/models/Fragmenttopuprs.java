package com.kodrindonesia.mokes.models;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kodrindonesia.mokes.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragmenttopuprs.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragmenttopuprs#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmenttopuprs extends Fragment {
    public static Fragmenttopuprs newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title", title);
        Fragmenttopuprs fragment = new Fragmenttopuprs();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_up_rs,container,false);

        return view;
    }


}
