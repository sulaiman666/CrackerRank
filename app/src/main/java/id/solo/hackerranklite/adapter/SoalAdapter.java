package id.solo.hackerranklite.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.solo.hackerranklite.MainActivity;
import id.solo.hackerranklite.R;
import id.solo.hackerranklite.SoalActivity;
import id.solo.hackerranklite.entity.Soal;

public class SoalAdapter extends RecyclerView.Adapter<SoalAdapter.SoalViewHolder> {
    private ArrayList<Soal> dataSoal;
    private Context context;

    public SoalAdapter(Context context, ArrayList<Soal> dataSoal) {
        this.context = context;
        this.dataSoal = dataSoal;
    }

    @NonNull
    @Override
    public SoalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_soal, parent, false);
        return new SoalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoalViewHolder holder, int position) {
        holder.tvJudulSoal.setText(dataSoal.get(position).getNamaSoal());
        holder.tvDifficultySoal.setText(dataSoal.get(position).getDifficultySoal());
        holder.tvKategoriSoal.setText(dataSoal.get(position).getKategoriSoal());

        if (dataSoal.get(position).isSolved()) {
            holder.btnStartSoal.setEnabled(false);
        } else {
            holder.btnStartSoal.setOnClickListener(v -> {
                Intent bukaSoal = new Intent(context, SoalActivity.class);
                bukaSoal.putExtra("soal", dataSoal.get(position));
                context.startActivity(bukaSoal);
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataSoal.size();
    }

    public class SoalViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudulSoal, tvDifficultySoal, tvKategoriSoal;
        Button btnStartSoal;

        public SoalViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudulSoal = itemView.findViewById(R.id.tv_judul_soal);
            tvDifficultySoal = itemView.findViewById(R.id.tv_difficulty_soal);
            tvKategoriSoal = itemView.findViewById(R.id.tv_kategori_soal);
            btnStartSoal = itemView.findViewById(R.id.btn_start_soal);
        }
    }
}
