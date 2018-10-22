package com.example.amministratore.esamefsespinelli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView helloTxt;
    Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        helloTxt = findViewById(R.id.hello_txt);
        logoutBtn = findViewById(R.id.button_logout);

        String message = "Benvenuto ";

        message += getIntent().getStringExtra("email");

        helloTxt.setText(message);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
