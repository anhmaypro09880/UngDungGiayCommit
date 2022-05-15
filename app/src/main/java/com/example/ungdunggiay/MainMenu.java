package com.example.ungdunggiay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {

    ViewFlipper viewFlipper;
    SanPham entitygiay;
    RecyclerView recyclerView;
    ArrayList<SanPham> listGiay;
    AdapterTrangChu adapterTrangChu;
    Context context;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FirebaseDatabase test = FirebaseDatabase.getInstance();
    DatabaseReference data = test.getReference("SanPham");
    public com.example.ungdunggiay.DatabaseHoaDon db;
    public static String email;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        db= Room.databaseBuilder(getApplicationContext(),
                com.example.ungdunggiay.DatabaseHoaDon.class,"HoadonBH1.db").allowMainThreadQueries().build();
        KhachHangDao khachHangDao = db.KhachHangDao();
//        khachHangDao.ThemKH(new KhachHang("Dao Cao Thang","0385553842","Go Vap","a@gmail.com"));
//        Intent intent = new Intent(MainMenu.this,MainActivity.class);
        Intent intent = this.getIntent();
         email = intent.getStringExtra("email");
//        Bundle bundle = getIntent().getExtras();
//        String email = bundle.getString("email");
        TextView test = findViewById(R.id.idKH);
        KhachHang khachHang= khachHangDao.getkhEmail(email);
        test.setText(khachHang.getTenKH());

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navicationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.menu_Open,R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.sanpham:
                        Log.i("MENU_DRAWER_TAG","Sản phẩm is cliked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent = new Intent(MainMenu.this,MainSanPham.class);
                        intent.putExtra("email",email);
                        startActivity(intent);
                        break;
                    case R.id.hoadon:
                        Log.i("MENU_DRAWER_TAG","Hóa đơn is cliked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent1 = new Intent(MainMenu.this,ActivityDonHang.class);
                        intent1.putExtra("email",email);
                        startActivity(intent1);
                        break;
                    case R.id.ttcanhan:
                        Log.i("MENU_DRAWER_TAG","Thông tin cá nhân is cliked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent2= new Intent(MainMenu.this,ActivityThongTinCaNhan.class);
                        intent2.putExtra("email",email);
                        startActivity(intent2);

                        break;
                    case R.id.dangxuat:
                        Log.i("MENU_DRAWER_TAG","Đăng xuất is cliked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent i = new Intent(MainMenu.this,MainActivity.class);
                        startActivity(i);
                        break;
                }

                return true;
            }
        });





        recyclerView = findViewById(R.id.id_rcv);
        listGiay = new ArrayList<>();
        data();
        adapterTrangChu = new AdapterTrangChu(listGiay, this);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainMenu.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterTrangChu);


        viewFlipper = findViewById(R.id.viewFlipper);
        ActionViewFlipper();

        ImageView imgCart = findViewById(R.id.idGioHangTrangChu);
        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,ActivityGioHang.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutoolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }


    private void data() {
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listGiay.clear();
                for(DataSnapshot s : snapshot.getChildren()){
                    SanPham acc = s.getValue(SanPham.class);
                    listGiay.add(acc);
                }
                adapterTrangChu.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainMenu.this,"get fail", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://live.staticflickr.com/65535/52070992493_ab4656a429.jpg");
        mangquangcao.add("https://live.staticflickr.com/65535/52069945492_9f83cb930b_c.jpg");
        mangquangcao.add("https://live.staticflickr.com/65535/52071226704_5e680d6504_h.jpg");
        mangquangcao.add("https://live.staticflickr.com/65535/52070997601_db9d3f157b_w.jpg");
        for(int i = 0;i<mangquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setInAnimation(animation_slide_out);
    }
}