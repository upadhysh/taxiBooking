package com.example.findyourride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.maps.SupportMapFragment;

public class DisplayMessageActivity extends AppCompatActivity {

    Boolean cabRide = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_text);

        Intent displayIntent = getIntent();
        final String message = displayIntent.getStringExtra(Constants.DISPLAY_MESSAGE);

        final TextView displayBox = findViewById(R.id.display_name);
        displayBox.setText("Hello " + message + " beach!!!");
        final ImageButton btn = (ImageButton)findViewById(R.id.floatingActionButton);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cabRide = cabRide == false;
                if(cabRide){
                    btn.setColorFilter(Color.RED);
                    displayBox.setText("Why you click " + message + " beach!!!");
                }
                else {
                    btn.setColorFilter(Color.YELLOW);
                    btn.setBackgroundResource(R.drawable.common_google_signin_btn_icon_light);
                    displayBox.setText("Click again " + message + " beach!!!");
                }
            }
        });

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();

    }

}
