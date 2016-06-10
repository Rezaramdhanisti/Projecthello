package com.Reza.leo.models;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.Reza.leo.MainActivity;
import com.Reza.leo.R;

/**
 * Created by User on 04/03/2016.
 */
public class Popupactivity extends AppCompatActivity {

Button pindahpopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        pindahpopup = (Button) findViewById(R.id.buttonclose);
        pindahpopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_obj = new Intent(Popupactivity.this, MainActivity.class);
                startActivity(intent_obj);

            }
        });
    }

}
