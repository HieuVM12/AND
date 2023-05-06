package com.example.apppbc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apppbc.api.ApiService;
import com.example.apppbc.model.User;
import com.example.apppbc.model.UserSession;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPass;

    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        etName = findViewById(R.id.etName);
        etPass = findViewById(R.id.etPass);

        btnLogin = findViewById(R.id.buttonLg);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String pass = etPass.getText().toString();
                callLoginApi(name, pass);
            }
        });
    }

    private void callLoginApi(String name, String pass) {
        ApiService.apiService.login(name, pass).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User userResponse = response.body();
               if(userResponse == null ){
                   Toast.makeText(LoginActivity.this, "Sai tên đăng nhập hoặc mật khẩu",Toast.LENGTH_SHORT).show();
               }
                else {
                   Intent intent = new Intent(LoginActivity.this, MainAppActivity.class);
                   UserSession.getInstance().setUsername(userResponse.getId()+"");
                   startActivity(intent);
               }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Sai tên đăng nhập hoặc mật khẩu",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
