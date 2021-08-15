package id.solo.hackerranklite.services;

import java.util.ArrayList;

import id.solo.hackerranklite.entity.Soal;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SoalInterface {
    @GET("ujian/")
    Call<ArrayList<Soal>> getAll();

    @GET("ujian/solved")
    Call<ArrayList<Soal>> getSolvedSoal();

    @POST("ujian/solved")
    Call<String> postSolvedSoal(Soal soal);
}
