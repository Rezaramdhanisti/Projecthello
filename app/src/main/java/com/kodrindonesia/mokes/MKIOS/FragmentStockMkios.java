package com.kodrindonesia.mokes.MKIOS;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kodrindonesia.mokes.R;


public class FragmentStockMkios extends Fragment {

    public static FragmentStockMkios newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title",title);
        FragmentStockMkios fragment = new FragmentStockMkios();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.mkios_frag_ret_stock, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event

}
