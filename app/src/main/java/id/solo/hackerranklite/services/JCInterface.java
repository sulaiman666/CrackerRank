package id.solo.hackerranklite.services;

import id.solo.hackerranklite.entity.SubmissionCode;
import id.solo.hackerranklite.entity.Token;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JCInterface {
    @GET("submissions/{token}")
    Call<SubmissionCode> getSubmission(@Path("token") String token);

    @POST("submissions")
    Call<Token> postSubmission(@Query("base64_encoded") String base64,
                               @Query("fields") String fields,
                               @Body RequestBody jsonCode);
}
