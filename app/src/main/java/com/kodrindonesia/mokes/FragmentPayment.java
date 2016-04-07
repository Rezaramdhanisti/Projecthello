package com.kodrindonesia.mokes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by royyan on 2/11/2016.
 */
public class FragmentPayment extends Fragment {

    private MainActivity mainActivity;

    public static FragmentPayment newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title", title);
        FragmentPayment fragment = new FragmentPayment();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentPayment() {
        Log.d(LoginActivity.TAG, "construct fragment payment");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment,container,false);

        Button btnnext = (Button) view.findViewById(R.id.purch_cr_btn_next);
//        Button btnNotNow = (Button) view.findViewById(R.id.paymmnt_btn_not_now);
//
        Button[] btn_ctrl = {btnnext };

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

        if (id == R.id.purch_cr_btn_next) {
            mainActivity.setupFragmentUser();
            mainActivity.setupFragmentNext();
        }
    }
    }

