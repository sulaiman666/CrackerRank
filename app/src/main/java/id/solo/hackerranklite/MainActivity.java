package id.solo.hackerranklite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import id.solo.hackerranklite.adapter.SoalAdapter;
import id.solo.hackerranklite.entity.Soal;
import id.solo.hackerranklite.services.ApiClient;
import id.solo.hackerranklite.services.SoalInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvSoal;
    SoalAdapter soalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSoal = findViewById(R.id.rv_soal);

        SoalInterface soalInterface = ApiClient.getRetrofitSoal().create(SoalInterface.class);
        Call<ArrayList<Soal>> call = soalInterface.getAll();

        call.enqueue(new Callback<ArrayList<Soal>>() {
            @Override
            public void onResponse(Call<ArrayList<Soal>> call, Response<ArrayList<Soal>> response) {
                soalAdapter = new SoalAdapter(MainActivity.this, response.body());

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,
                        RecyclerView.VERTICAL, false);

                rvSoal.setLayoutManager(layoutManager);
                rvSoal.setAdapter(soalAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Soal>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Recycler Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        SoalInterface soalInterface = ApiClient.getRetrofitSoal().create(SoalInterface.class);
//        Call<ArrayList<Soal>> call = soalInterface.getAll();
//
//        call.enqueue(new Callback<ArrayList<Soal>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Soal>> call, Response<ArrayList<Soal>> response) {
//                soalAdapter = new SoalAdapter(MainActivity.this, response.body());
//
//                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,
//                        RecyclerView.VERTICAL, false);
//
//                rvSoal.setLayoutManager(layoutManager);
//                rvSoal.setAdapter(soalAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Soal>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Recycler Failure", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}