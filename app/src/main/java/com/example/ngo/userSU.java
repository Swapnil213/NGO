package com.example.ngo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class userSU extends AppCompatActivity {

    TextView have_acc;
    EditText un,ue,up,u_pass,uc_pass;
    Button r_btn;

    String Pattern = "^[A-Za-z0-9+_.-]+@(.+)$";
    ProgressDialog pd;
    FirebaseAuth match;
    FirebaseUser User;
    FirebaseDatabase db;
    DatabaseReference refer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_su);

        have_acc = findViewById(R.id.lgtext);
        un = findViewById(R.id.UN);
        ue = findViewById(R.id.UE);
        up = findViewById(R.id.UP);
        u_pass = findViewById(R.id.Upass);
        uc_pass = findViewById(R.id.UCpass);
        r_btn = findViewById(R.id.ru);
        pd = new ProgressDialog(this);
        match = FirebaseAuth.getInstance();
        User = match.getCurrentUser();

        have_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(userSU.this,MainActivity.class));
            }
        });

        r_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = FirebaseDatabase.getInstance();
                refer = db.getReference("user");
                performAuth();
            }
        });
    }

    private void performAuth() {
        String Email = ue.getText().toString();
        String pass = u_pass.getText().toString();
        String c_pass = uc_pass.getText().toString();
        String name = un.getText().toString();
        String phone = up.getText().toString();
        Helper helper = new Helper(name,Email,phone,pass);


        if(pass.isEmpty()||name.isEmpty()||phone.isEmpty())
        {
            Toast.makeText(userSU.this,"No field should be empty..",Toast.LENGTH_SHORT).show();
        }
        else if(!Email.matches(Pattern))
        {
            ue.setError("Enter Valid Email..");
        } else if (pass.length()<6)
        {
            u_pass.setError("Password must be of length 6..");
        } else if (!pass.matches(c_pass))
        {
            uc_pass.setError("passwords won't match..");
        }
        else
        {
            refer.child(name).setValue(helper);
            Toast.makeText(userSU.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(userSU.this,MainActivity.class));
        }
    }
}