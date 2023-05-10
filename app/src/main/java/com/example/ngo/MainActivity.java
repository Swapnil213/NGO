package com.example.ngo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText uid,pass;
    Button button,button2;
    TextView SUU,SUN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uid=findViewById(R.id.uid);
        pass=findViewById(R.id.pass);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        SUU= findViewById(R.id.SUU);
        SUN=findViewById(R.id.SUN);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkUN() && checkUP())
                {
                    checkUser();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Something Went wrong..", Toast.LENGTH_SHORT).show();                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=uid.getEditableText().toString();
                String p=pass.getEditableText().toString();
                if(user.equals("NGO1") && p.equals("!@#$"))
                {
                    startActivity(new Intent(MainActivity.this,Ngo_profile.class));
                }
                else {
                    Toast.makeText(MainActivity.this, "Enter Valid User Details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        SUU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,userSU.class));
            }
        });

        SUN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,userSN.class));
            }
        });

    }

    public Boolean checkUN()
    {
        String val= uid.getText().toString();
        if(val.isEmpty())
        {
            uid.setError("Username Cannot be Empty..");
            return  false;
        }
        else
        {
            uid.setError(null);
            return true;
        }
    }

    public Boolean checkUP()
    {
        String val= uid.getText().toString();
        if(val.isEmpty())
        {
            pass.setError("Password Cannot be Empty..");
            return  false;
        }
        else
        {
            pass.setError(null);
            return true;
        }
    }

    public void checkUser()
    {
        String user = uid.getText().toString().trim();
        String password = pass.getText().toString().trim();
        DatabaseReference refer = FirebaseDatabase.getInstance().getReference("user");
        Query checkUser = refer.orderByChild("name").equalTo(user);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    uid.setError(null);
                    String passDb = snapshot.child(password).child("user").getValue(String.class);

                    if(!Objects.equals(passDb,password))
                    {
                        uid.setError(null);
                        startActivity(new Intent(MainActivity.this,List.class));
                    }
                    else
                    {
                        pass.setError("Invalid Credentials..");
                        pass.requestFocus();
                    }
                }
                else
                {
                    uid.setError("Invalid Credentials..");
                    uid.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}