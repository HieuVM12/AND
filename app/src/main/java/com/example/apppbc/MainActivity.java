package com.example.apppbc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apppbc.api.ApiService;
import com.example.apppbc.model.Post;
import com.example.apppbc.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etEmail;
    private EditText etPass;
    private Button btnSign;
    private Button btnLog;
    private TextView tex;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        tex = findViewById(R.id.textView2);






        btnSign = findViewById(R.id.buttonSign);
        btnLog = findViewById(R.id.buttonLogin);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String pass = etPass.getText().toString();
                callSignUpApi(name, email, pass);
//                callSendPost();
            }
        });
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }



    private void callSignUpApi(String name, String email, String pass) {
        User user = new User(null ,name, email,pass);
        tex.setText(name);
        ApiService.apiService.signUp(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(MainActivity.this, "Đăng ký thành công",Toast.LENGTH_SHORT).show();
                User userResponse = response.body();
                tex.setText(userResponse.toString());

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Đăng ký thất bại",Toast.LENGTH_SHORT).show();
                tex.setText("ga");
            }
        });
    }
}
