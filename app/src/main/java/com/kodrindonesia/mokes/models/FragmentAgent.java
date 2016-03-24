package com.kodrindonesia.mokes.models;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kodrindonesia.mokes.R;

/**
 */
public class FragmentAgent extends Fragment {
Button Topupdeposit,Topuprs;


    public static FragmentAgent newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title",title);
        FragmentAgent fragment = new FragmentAgent();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agent,container,false);
        Button Topupdeposit = (Button) view.findViewById(R.id.form_top_up_deposit);
        Button Topuprs = (Button) view.findViewById(R.id.form_top_up_rs);
        TextView jenistransaksi = (TextView) view.findViewById(R.id.form_pilih_jenis_transaksi);


        return view;
    }



}
