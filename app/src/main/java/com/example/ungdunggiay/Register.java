package com.example.ungdunggiay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

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

public class Register extends AppCompatActivity {
    EditText edtEmail,edtPass1,edtPass2;
    TextView txtCreateAcc;
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);

        khaiBao();
        createAccount();

    }

    private void createAccount() {
        txtCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String pass1 = edtPass1.getText().toString();
                String pass2 = edtPass2.getText().toString();
                if(pass1.matches(pass2)){
                    auth.createUserWithEmailAndPassword(email,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {   DatabaseHoaDon db = Room.databaseBuilder(getApplicationContext(),
                                    DatabaseHoaDon.class,"HoadonBH1.db").allowMainThreadQueries().build();
                                KhachHangDao khachHangDao = db.KhachHangDao();
                                khachHangDao.ThemKH(new KhachHang(email));
                                Toast.makeText(Register.this,"Đăng kí thành công",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Register.this,MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Register.this,"Fail",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(Register.this,"Mật khẩu không giống nhau",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void khaiBao() {
        edtEmail = findViewById(R.id.edtTen);
        edtPass1 = findViewById(R.id.edtPass1);
        edtPass2 = findViewById(R.id.edtPass2);
        txtCreateAcc = findViewById(R.id.btnRegister);
    }
}