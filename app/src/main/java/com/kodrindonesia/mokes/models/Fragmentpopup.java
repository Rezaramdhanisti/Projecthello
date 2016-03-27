package com.kodrindonesia.mokes.models;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kodrindonesia.mokes.R;

public class Fragmentpopup extends Fragment {
    Button closebutton;
    TextView judul, promosatu, promodua, promotiga, promoempat;
    ImageView gambarpromo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmentpopup, container, false);

        closebutton = (Button) view.findViewById(R.id.buttonclose);
        judul = (TextView) view.findViewById(R.id.textView);
        promosatu = (TextView) view.findViewById(R.id.textView2);
        promodua = (TextView) view.findViewById(R.id.textView3);
        promotiga = (TextView) view.findViewById(R.id.textView4);
        promoempat = (TextView) view.findViewById(R.id.textView5);
        gambarpromo = (ImageView) view.findViewById(R.id.imageView4);

        Button closebutton = (Button) view.findViewById(R.id.buttonclose);
        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }

            private void finish() {
            }
        });


        return view;
    }
}
