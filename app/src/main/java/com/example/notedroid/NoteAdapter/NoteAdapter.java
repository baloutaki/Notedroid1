package com.example.notedroid.NoteAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notedroid.R;
import com.example.notedroid.model.Note;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    class NoteViewHolder extends RecyclerView.ViewHolder{
        final TextView tvSetup;
        final TextView tvDate;
        final Button btnDetail;

        final View.OnClickListener detailListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //welke card?
                int position = getAdapterPosition();
                //data in bundle om door te geven
                Bundle data = new Bundle();
                data.putSerializable("passedNote", items.get(position));
                //navigatie starten
                Navigation.findNavController(view).navigate(R.id.noteList_to_details, data);
            }
        };


        public NoteViewHolder(@NonNull View itemView){
            super(itemView);
            tvSetup = itemView.findViewById(R.id.tv_setup);
            tvDate = itemView.findViewById(R.id.tv_date);
            btnDetail = itemView.findViewById(R.id.btn_detail);
            btnDetail.setOnClickListener(detailListener);
        }
    }

    private ArrayList<Note> items;

    public NoteAdapter(){ items = new ArrayList<>();}

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View card = layoutInflater.inflate(R.layout.card_deluxe , parent, false);

        return new NoteViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NoteViewHolder holder, int position) {
        Note currentNote = items.get(position);
        holder.tvSetup.setText(currentNote.getTitle());
        holder.tvDate.setText(currentNote.getDate().toString());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void addItems(ArrayList<Note> notes) {
        items.addAll(notes);
    }

    }



