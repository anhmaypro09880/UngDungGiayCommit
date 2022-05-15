package com.example.ungdunggiay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView txtCreateAcc, txtLogin;
    EditText edtEmail,edtPassword;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        khaiBao();
        openFormRegister();
        login();



    }

    private void login() {
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String pass = edtPassword.getText().toString();
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Đăng nhập thành công ",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this,MainMenu.class);
                            intent.putExtra("email",email);
//                            Intent i = new Intent(MainActivity.this,MainMenu.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(MainActivity.this,"Đăng nhập thất bại",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
    }


    private void openFormRegister() {
        txtCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Register.class);
                startActivity(i);
            }
        });
    }

    public void khaiBao() {
        edtEmail = findViewById(R.id.edtTen);
        edtPassword = findViewById(R.id.edtPass1);
        txtCreateAcc = findViewById(R.id.txtCreateAcc);
        txtLogin = findViewById(R.id.btnLogin);
    }
}