package com.Reza.leo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class FragmentControlRoom extends Fragment {

    private MainActivity mainActivity;

    public static FragmentControlRoom newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title",title);
        FragmentControlRoom fragment = new FragmentControlRoom();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentControlRoom(){
        Log.d(LoginActivity.TAG, "construct fragment control room");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_control_room,container,false);


        ImageButton btnTransfer = (ImageButton) view.findViewById(R.id.btn_transaksi_);
        ImageButton btnAddBalance = (ImageButton) view.findViewById(R.id.btn_home_page);

        ImageButton[] btn_ctrl = { btnTransfer, btnAddBalance};

        for (ImageButton element: btn_ctrl) {
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
        mainActivity = (MainActivity)context;
    }

    private void onBtnCliked(View item){
        int id = item.getId();


       if (id == R.id.btn_transaksi_) {
            mainActivity.setupTransactionPage();
        }

        else if (id == R.id.btn_home_page) {
            mainActivity.setupHomePage();
        }
    }
}
