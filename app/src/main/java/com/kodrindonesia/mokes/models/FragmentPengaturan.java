package com.kodrindonesia.mokes.models;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kodrindonesia.mokes.R;


public class FragmentPengaturan extends Fragment {



    public static FragmentPengaturan newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title",title);
        FragmentPengaturan fragment = new FragmentPengaturan();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pengaturan,container,false);

        return view;
    }


}
