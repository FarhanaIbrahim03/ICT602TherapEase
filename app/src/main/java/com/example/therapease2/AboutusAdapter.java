package com.example.therapease2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AboutusAdapter extends RecyclerView.Adapter<AboutusAdapter.TeamViewHolder> {
    private List<Aboutus> teamList;

    public AboutusAdapter(List<Aboutus> teamList) {
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_about_us, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Aboutus member = teamList.get(position);
        holder.imageView.setImageResource(member.getImageResId());
        holder.nameTextView.setText(member.getName());
        holder.groupTextView.setText(member.getGroup());
        holder.studentIdTextView.setText(member.getStudentId());
        holder.courseTextView.setText(member.getCourse());
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView, groupTextView, studentIdTextView, courseTextView;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            groupTextView = itemView.findViewById(R.id.groupTextView);
            studentIdTextView = itemView.findViewById(R.id.studentIdTextView);
            courseTextView = itemView.findViewById(R.id.courseTextView);
        }
    }
}
