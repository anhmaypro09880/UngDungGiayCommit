package com.example.ungdunggiay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.MailTo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainSanPham extends AppCompatActivity {
    FirebaseDatabase test = FirebaseDatabase.getInstance();
    DatabaseReference data = test.getReference("SanPham");
    ListView lvShoes;
    SanPhamAdapter adt;
    ArrayList<SanPham> list = new ArrayList<>();
    TextView txt;
    ImageView img;
    public String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_san_pham);

        khaiBao();
        img = findViewById(R.id.imgCart);

        TextView test = findViewById(R.id.txtSanPham);
        Intent intent = this.getIntent();
        email = intent.getStringExtra("email");
//        test.setText(email);

        adt = new SanPhamAdapter(this, R.layout.list_viewsanpham, list) ;

        lvShoes.setAdapter(adt);
        getallListSanPham();


        ImageView imgcart = findViewById(R.id.imgCart);
        imgcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainSanPham.this,ActivityGioHang.class);
                intent1.putExtra("email",email);
                startActivity(intent1);
            }
        });

        lvShoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                SanPham sp = (SanPham) adapterView.getAdapter().getItem(i);
//                Toast.makeText(MainSanPham.this,"aaaaa",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainSanPham.this,ActivityDetailProduct.class);
                intent.putExtra("tenSanPham",list.get(i).getTenSanPham());
                intent.putExtra("moTa",list.get(i).getMoTa());
                intent.putExtra("giaThanh",list.get(i).getGiaTien());
                intent.putExtra("hinh1",list.get(i).getHinh1());
                intent.putExtra("hinh2",list.get(i).getHinh2());
                intent.putExtra("hinh3",list.get(i).getHinh3());
                intent.putExtra("hinh4",list.get(i).getHinh4());
                intent.putExtra("hinh4",list.get(i).getHinh4());
                intent.putExtra("danhGia",list.get(i).getDanhGia());
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

    }

    private void khaiBao() {
        lvShoes = findViewById(R.id.lvShoes);
        txt = findViewById(R.id.txtSanPham);
    }
    private void getallListSanPham(){
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot s : snapshot.getChildren()){
                    SanPham acc = s.getValue(SanPham.class);
                    list.add(acc);
                }
                adt.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainSanPham.this,"get fail",Toast.LENGTH_LONG).show();
            }
        });
    }

}