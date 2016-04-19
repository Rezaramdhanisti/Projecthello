package com.kodrindonesia.mokes.models;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kodrindonesia.mokes.MainActivity;
import com.kodrindonesia.mokes.R;

/**
 */
public class FragmentAgent extends Fragment {
Button Topupdeposit,Topuprs;

    private MainActivity mainActivity;

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

        Button topupdeposit = (Button) view.findViewById(R.id.purch_cr_btn_agen_satu);
        Button topuprs = (Button) view.findViewById(R.id.purch_cr_btn_agen_dua);
//
        Button[] btn_ctrl = {topupdeposit,topuprs };

        for (Button element: btn_ctrl) {
            element.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBtnCliked(v);
                }
            });
        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    private void onBtnCliked(View item) {
        int id = item.getId();

        if (id == R.id.purch_cr_btn_agen_satu) {
            mainActivity.setupFragmentUser();
            mainActivity.setupFragmenttopupdeposit();
        }
        if (id == R.id.purch_cr_btn_agen_dua) {
            mainActivity.setupFragmentUser();
            mainActivity.setupFragmenttopuprs();
        }
    }

    }


