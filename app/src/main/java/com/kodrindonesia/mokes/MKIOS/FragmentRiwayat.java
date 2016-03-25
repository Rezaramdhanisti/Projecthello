package com.kodrindonesia.mokes.MKIOS;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kodrindonesia.mokes.R;


public class FragmentRiwayat extends Fragment {

    public static FragmentRiwayat newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title",title);
        FragmentRiwayat fragment = new FragmentRiwayat();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.riwayat_transaksi,container,false);

        return view;
    }


}
