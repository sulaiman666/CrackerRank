package id.solo.hackerranklite.services;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit;
    public static Retrofit retrofitSoal;
    public static String URLJC = "http://103.157.81.54:2358/";
    public static String URLSoal = "http://192.168.11.166:8085/";

    public static Retrofit getRetrofit() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("dewaganteng"
                        , "dewaganteng").build();
                return chain.proceed(newRequest);
            }
        };

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl(URLJC)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

        return retrofit;
    }

    public static Retrofit getRetrofitSoal() {
        if (retrofitSoal == null) {
            retrofitSoal = new Retrofit.Builder()
                    .baseUrl(URLSoal)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitSoal;
    }
}
