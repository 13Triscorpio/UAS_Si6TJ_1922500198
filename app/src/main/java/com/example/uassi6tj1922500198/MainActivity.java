package com.example.uassi6tj1922500198;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.uassi6tj1922500198.R;
import com.example.uassi6tj1922500198.dosen.DosenJsonPlaceHolderAPI;
import com.example.uassi6tj1922500198.dosen.DosenPost;
import com.example.uassi6tj1922500198.dosen.dosen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private DosenJsonPlaceHolderAPI jsonPlaceHolderAPI;

    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.flot);
        //Ketika di klik
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, dosen.class);
                startActivity(i);
            }
        });

        //Penampil data
        textView = findViewById(R.id.text_dosen_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.61.220/mit/") //jika data tidak tampil ubah ip
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderAPI = retrofit.create(DosenJsonPlaceHolderAPI.class);
        getPosts();
    }

    private void getPosts() {
        Map<String, String > parameters = new HashMap<>();
        Call<List<DosenPost>> call = jsonPlaceHolderAPI.getPosts();
        call.enqueue(new Callback<List<DosenPost>>() {
            @Override
            public void onResponse(Call<List<DosenPost>> call, Response<List<DosenPost>> response) {
                if (!response.isSuccessful()){
                    textView.setText("Code: " + response.code());
                    return;
                }
                List<DosenPost> posts = response.body();
                for (DosenPost post : posts) {
                    String content = "";
                    content += "NIDN: " + post.getNidn() + "\n";
                    content += "Nama Dosen : " + post.getNamaDosen() + "\n";
                    content += "Jabatan : " + post.getJabatan() + "\n";
                    content += "Golongan Pangkat : " + post.getGolPang() + "\n";
                    content += "Keahlian : " + post.getKeahlian() + "\n";
                    content += "Program Studi : " + post.getProgramStudi() + "\n\n";
                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<DosenPost>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}