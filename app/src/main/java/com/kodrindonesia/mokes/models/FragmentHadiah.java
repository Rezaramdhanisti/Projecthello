package com.kodrindonesia.mokes.models;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kodrindonesia.mokes.R;


public class FragmentHadiah extends Fragment {


    public static FragmentHadiah newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title",title);
        FragmentHadiah fragment = new FragmentHadiah();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_hadiah_tunai, container, false);
        return view;
    }



}
