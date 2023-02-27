package sszj.s.flightbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button login, signup;
    EditText email, password, name;
//login
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                if (TextUtils.isEmpty(Name)) {
                    Toast.makeText(LoginActivity.this, "Please add your Full name", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(LoginActivity.this, "Please add you Email Address", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(Password)) {
                    Toast.makeText(LoginActivity.this, "Please add a strong password contains ", Toast.LENGTH_SHORT).show();
                    return;

                } else if (!Password.matches(PASSWORD_PATTERN)) {
                    Toast.makeText(LoginActivity.this, "Password must be at least 8 characters and contain at least one letter and one number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(Password) || TextUtils.isEmpty(Name)) {
                    Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;

                } else {

                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("name", Name.toString());
                    intent.putExtra("email", Email.toString());
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }

    private static final String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
}