package sszj.s.flightbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button login, signup;
    EditText name, email, password, idNumber, mobile, nationaity;
//register
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile);
        idNumber = findViewById(R.id.nic);
        nationaity = findViewById(R.id.nationality);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString().trim();
                String Mobile = mobile.getText().toString().trim();
                String emailText = email.getText().toString().trim();
                String passwordText = password.getText().toString().trim();
                String ID = idNumber.getText().toString().trim();
                String Nationality = nationaity.getText().toString().trim();

                if (TextUtils.isEmpty(Name)) {
                    Toast.makeText(RegisterActivity.this, "Please add your Full name", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(emailText)) {
                    Toast.makeText(RegisterActivity.this, "Please add you Email Address", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(passwordText)) {
                    Toast.makeText(RegisterActivity.this, "Please add a strong password contains ", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!passwordText.matches(PASSWORD_PATTERN)) {
                    Toast.makeText(RegisterActivity.this, "Password must be at least 8 characters and contain at least one letter and one number", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(Mobile)) {
                    Toast.makeText(RegisterActivity.this, "Please add your Mobile Number", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(ID)) {
                    Toast.makeText(RegisterActivity.this, "Please add your Emirates ID", Toast.LENGTH_SHORT).show();
                    return;

                } else if (TextUtils.isEmpty(Nationality)) {
                    Toast.makeText(RegisterActivity.this, "You can't keep Nationality Empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText) || TextUtils.isEmpty(Name) || TextUtils.isEmpty(Mobile) || TextUtils.isEmpty(ID) || TextUtils.isEmpty(Nationality)) {
                    Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;

                } else {
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);

                    Toast.makeText(RegisterActivity.this, "Registered!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(RegisterActivity.this, "Welcome To Flight Booking App", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private static final String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

}