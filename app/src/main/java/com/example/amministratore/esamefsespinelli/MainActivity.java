package com.example.amministratore.esamefsespinelli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText emailEd, passwordEd;
    Button buttonLogin, buttonRubrica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEd = (EditText) findViewById(R.id.email_ed);
        passwordEd = (EditText) findViewById(R.id.password_ed);
        buttonLogin = (Button) findViewById(R.id.login);
        buttonRubrica = findViewById(R.id.rubrica);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailEd.getText().toString();
                String password = passwordEd.getText().toString();

                if(login(email,password)){
                    Intent accessOk = new Intent(MainActivity.this, SecondActivity.class);
                    accessOk.putExtra("email", email);
                    startActivity(accessOk);
                }
            }
        });


        buttonRubrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openRubrica = new Intent(MainActivity.this, RubricaActivity.class);
                startActivity(openRubrica);
            }
        });
    }

    public boolean login(String email, String password){

        if (!isValidEmail(email)) {
            Toast.makeText(MainActivity.this, R.string.noemail, Toast.LENGTH_LONG).show();
        } else if (password.length() < 6) {
            Toast.makeText(MainActivity.this, R.string.nopassword, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.success, Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}