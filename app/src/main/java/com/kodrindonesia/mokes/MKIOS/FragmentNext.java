package com.kodrindonesia.mokes.MKIOS;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kodrindonesia.mokes.R;


public class FragmentNext extends Fragment {


    public static FragmentNext newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title",title);
        FragmentNext fragment = new FragmentNext();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_next, container, false);
    }



   }
