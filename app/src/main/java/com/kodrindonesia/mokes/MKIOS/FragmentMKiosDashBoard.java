package com.kodrindonesia.mokes.MKIOS;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kodrindonesia.mokes.LoginActivity;
import com.kodrindonesia.mokes.MainActivity;
import com.kodrindonesia.mokes.R;

/**
 * Created by royyan on 2/11/2016.
 */
public class FragmentMKiosDashBoard extends Fragment {

    private MainActivity mainActivity;

    public static FragmentMKiosDashBoard newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title", title);
        FragmentMKiosDashBoard fragment = new FragmentMKiosDashBoard();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentMKiosDashBoard(){
        Log.d(LoginActivity.TAG, "construct fragment M-Kios");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mkios_frag_dashboard,container,false);

        Button btncredittopup = (Button) view.findViewById(R.id.mkios_credit_topup_pertama);

        Button[] btn_ctrl = {btncredittopup};

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

    private void onBtnCliked(View item){
        int id = item.getId();

        if (id == R.id.mkios_credit_topup_pertama) {
                mainActivity.setupFragmentUser();
                mainActivity.setupFragmentStockMkios();
            }
        }
    }

