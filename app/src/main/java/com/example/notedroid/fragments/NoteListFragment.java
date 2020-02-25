package com.example.notedroid.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notedroid.NoteAdapter.NoteAdapter;
import com.example.notedroid.R;
import com.example.notedroid.model.Note;
import com.example.notedroid.model.NoteViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteListFragment extends Fragment {

    private NoteAdapter adapter;

    public NoteListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoteListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoteListFragment newInstance(String param1, String param2) {
        NoteListFragment fragment = new NoteListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_note_list, container, false);

        RecyclerView rvNotes = rootView.findViewById(R.id.rv_notes);

        RecyclerView.LayoutManager manager;

        manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false);

        rvNotes.setLayoutManager(manager);

        adapter = new NoteAdapter();
        rvNotes.setAdapter(adapter);

        NoteViewModel model = new ViewModelProvider(this).get(NoteViewModel.class);
        model.getNotes().observeForever(new Observer<ArrayList<Note>>() {
            @Override
            public void onChanged(ArrayList<Note> notes) {
                adapter.addItems(notes);
                adapter.notifyDataSetChanged();
            }
        });

        return rootView;
    }
}
