package com.kodrindonesia.mokes.models;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kodrindonesia.mokes.R;



public class Fragment_souvenir extends Fragment {


    public static Fragment_souvenir newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title",title);
        Fragment_souvenir fragment = new Fragment_souvenir();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_souvenir, container, false);
    }


}
