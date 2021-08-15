package id.solo.hackerranklite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Base64;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import id.solo.hackerranklite.codeview.CodeView;
import id.solo.hackerranklite.entity.Code;
import id.solo.hackerranklite.entity.Soal;
import id.solo.hackerranklite.entity.SubmissionCode;
import id.solo.hackerranklite.entity.Token;
import id.solo.hackerranklite.services.ApiClient;
import id.solo.hackerranklite.services.JCInterface;
import id.solo.hackerranklite.services.SoalInterface;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SoalActivity extends AppCompatActivity {
    CodeView edtCode;
    TextView tvIsiSoal, tvJudulSoalActivity;
    Soal soal;
    Code code;
    Button btnSubmit;
    String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);

        edtCode = findViewById(R.id.edt_code);
        btnSubmit = findViewById(R.id.btn_submit);
        tvIsiSoal = findViewById(R.id.tv_isi_soal);
        tvJudulSoalActivity = findViewById(R.id.tv_judul_soal_activity);

        soal = getIntent().getParcelableExtra("soal");

        // Decode template jawaban
        byte[] data = Base64.decode(soal.getTemplateJawaban(), Base64.DEFAULT);
        String templateJawaban = new String(data, StandardCharsets.UTF_8);

        tvJudulSoalActivity.setText(soal.getNamaSoal());
        tvIsiSoal.setText(Html.fromHtml(soal.getIsiSoal()));
        edtCode.setText(templateJawaban);

        btnSubmit.setOnClickListener(v -> {
            // Encode code
            String codeResult = edtCode.getText().toString();
            byte[] codeData = codeResult.getBytes(StandardCharsets.UTF_8);
            String base64 = Base64.encodeToString(codeData, Base64.DEFAULT);

            code = new Code();
            code.setLanguage_id(62);
            code.setSource_code(base64);
            code.setStdin("");

            Gson gson = new Gson();
            String json = gson.toJson(code);

            RequestBody jsonCode = RequestBody.create(MediaType.parse("text/plain"), json);
            JCInterface jcInterface = ApiClient.getRetrofit().create(JCInterface.class);
            Call<Token> call = jcInterface.postSubmission("true", "*", jsonCode);

            call.enqueue(new Callback<Token>() {
                @Override
                public void onResponse(Call<Token> call, Response<Token> response) {
                    assert response.body() != null;
                    Toast.makeText(SoalActivity.this, response.body().getToken(), Toast.LENGTH_SHORT).show();

                    checkToken(response.body().getToken());
                }

                @Override
                public void onFailure(Call<Token> call, Throwable t) {
                    Toast.makeText(SoalActivity.this, "Submission Error", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    private void checkToken(String token) {
        JCInterface jcInterface = ApiClient.getRetrofit().create(JCInterface.class);
        Call<SubmissionCode> call = jcInterface.getSubmission(token);

        call.enqueue(new Callback<SubmissionCode>() {
            @Override
            public void onResponse(Call<SubmissionCode> call, Response<SubmissionCode> response) {
                assert response.body() != null;
                // Compile success
                if (response.body().getStatus().getId() == 3) {
                    // Output benar
                    if (response.body().getStdout().equals(soal.getJawabanSoal())) {
                        soal.setSubmissionToken(token);
                        soal.setSolved(true);
                        Toast.makeText(SoalActivity.this, solvedUjian(soal), Toast.LENGTH_SHORT).show();
                        Intent solvedIntent = new Intent(SoalActivity.this, SuccessActivity.class);
                        startActivity(solvedIntent);
                        finish();
                    }
                    //Output Salah
                    else {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(SoalActivity.this);
                        dialog.setTitle("Output salah");
                        dialog.setMessage("Output kamu\n" +
                                response.body().getStdout() + "\n" +
                                "Output yang benar\n" +
                                soal.getJawabanSoal());
                        dialog.setPositiveButton("Coba lagi!",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(getApplicationContext(), "Semangat! Kamu bisa", Toast.LENGTH_LONG).show();
                                    }
                                });
                        AlertDialog alertDialog = dialog.create();
                        alertDialog.show();
                    }
                }
                // Error
                else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(SoalActivity.this);
                    dialog.setTitle(response.body().getStatus().getDescription());
                    dialog.setMessage(response.body().getCompileOutput());
                    dialog.setPositiveButton("Coba lagi!",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getApplicationContext(), "Semangat! Kamu bisa", Toast.LENGTH_LONG).show();
                                }
                            });
                    AlertDialog alertDialog = dialog.create();
                    alertDialog.show();
                }
            }

            @Override
            public void onFailure(Call<SubmissionCode> call, Throwable t) {
                Toast.makeText(SoalActivity.this, "Can't fetch submisson", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String solvedUjian(Soal soal) {
        SoalInterface soalInterface = ApiClient.getRetrofitSoal().create(SoalInterface.class);
        Call<String> call = soalInterface.postSolvedSoal(soal);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                s = response.body();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                s = "Can't upload solved condition";
            }
        });
        return s;
    }
}