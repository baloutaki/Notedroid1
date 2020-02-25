package com.example.notedroid.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class NoteViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Note>> notes;

    public MutableLiveData<ArrayList<Note>> getNotes(){
        if (notes == null){
            notes = new MutableLiveData<>();
            loadNotes();

        }
        return notes;
    }

    public void addNote(Note n){
        notes.getValue().add(n);
    }

    public void removeNote(Note n){
        notes.getValue().remove(n);
    }



    private  void loadNotes(){
        ArrayList<Note> tempList = new ArrayList<>();

        tempList.add(new Note("What to do today!", "Sporten"));


        notes.setValue(tempList);
    }
}
