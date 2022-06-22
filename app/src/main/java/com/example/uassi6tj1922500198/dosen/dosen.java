package com.example.uassi6tj1922500198.dosen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.uassi6tj1922500198.MainActivity;
import com.example.uassi6tj1922500198.R;
import com.example.uassi6tj1922500198.RequestHandler;

import java.util.HashMap;

public class dosen extends AppCompatActivity {
    private EditText txtetNIDN;
    private EditText txtetNmDosen;
    private EditText txtetJabatan;
    private EditText txtetGolongan;
    private EditText txtetKeahlian;
    private EditText txtetStudi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen);

        txtetNIDN = (EditText) findViewById(R.id.etNIDN);
        txtetNmDosen = (EditText) findViewById(R.id.etNmDosen);
        txtetJabatan = (EditText) findViewById(R.id.etJabatan);
        txtetGolongan = (EditText) findViewById(R.id.etGolongan);
        txtetKeahlian = (EditText) findViewById(R.id.etKeahlian);
        txtetStudi = (EditText) findViewById(R.id.etStudi);
    }

    public void save(View view){
        final String nidn             = txtetNIDN.getText().toString().trim();
        final String nama_dosen    = txtetNmDosen.getText().toString().trim();
        final String jabatan           = txtetJabatan.getText().toString().trim();
        final String gol_pang      = txtetGolongan.getText().toString().trim();
        final String keahlian    = txtetKeahlian.getText().toString().trim();
        final String program_studi    = txtetStudi.getText().toString().trim();

        class save2 extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(dosen.this, "Add...", "Wait...", false, false);
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                params.put("nidn", nidn);
                params.put("nama_dosen", nama_dosen);
                params.put("jabatan", jabatan);
                params.put("gol_pang", gol_pang);
                params.put("keahlian", keahlian);
                params.put("program_studi", program_studi);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest("http://192.168.61.220/mit/add_dosen.php", params);
                return res;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();

                //Pindah ke menu utama
                if (s.equals("berhasil")){
                    Intent i = new Intent(dosen.this, MainActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(dosen.this, "Data harus lengkap", Toast.LENGTH_SHORT).show();
                }
            }
        }
        save2 ae = new save2();
        ae.execute();
    }

    public void back(View view){
        Intent i = new Intent(dosen.this, MainActivity.class);
        startActivity(i);
    }

}