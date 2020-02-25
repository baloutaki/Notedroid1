package com.example.notedroid.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.notedroid.NoteAdapter.NoteAdapter;
import com.example.notedroid.R;
import com.example.notedroid.model.Note;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView titleTv = rootView.findViewById(R.id.tv_titel);
        TextView contentTv = rootView.findViewById(R.id.tv_content);
        TextView dateTv = rootView.findViewById(R.id.tv_date);

        Bundle data = getArguments();
        if (data != null) {
            if (data.containsKey("passedNote")) {
                Note note = (Note) data.getSerializable("passedNote");
                titleTv.setText(note.getTitle());
                contentTv.setText(note.getContent());
                dateTv.setText(note.getDate().toString());

            }
        }

        return rootView;
    }
}