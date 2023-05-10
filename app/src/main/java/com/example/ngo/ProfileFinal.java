package com.example.ngo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileFinal extends AppCompatActivity {

TextView to_map,to_analyse,veri;
ImageView chat,back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_final);

        chat = findViewById(R.id.chat);
        back = findViewById(R.id.back);

        to_map = findViewById(R.id.tomap);
        veri=findViewById(R.id.verify_D);
        to_analyse = findViewById(R.id.toanalyse);
        to_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileFinal.this,Map_Final.class));
            }
        });
        to_analyse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   gotoUrl("https://public.tableau.com/views/final_16829347221310/Dashboard1?:language=en-US&publish=yes&:display_count=n&:origin=viz_share_link");
            startActivity(new Intent(ProfileFinal.this,tableau.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileFinal.this,List.class));
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl="http://wa.me/+919405433269?text=Hi,Would like to know more about your NGO.";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
        veri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileFinal.this,verify.class));
            }
        });


    }

//    private void gotoUrl(String s) {
//        Uri uri = Uri.parse(s);
//        startActivity(new Intent(Intent.ACTION_VIEW,uri));
//    }
}