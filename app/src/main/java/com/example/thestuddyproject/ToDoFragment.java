package com.example.thestuddyproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thestuddyproject.datamodels.ToDoListModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ToDoFragment extends Fragment {


    ArrayList<ToDoListModel> theToDos =  new ArrayList<>();
    private FloatingActionButton addButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_todo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView =  view.findViewById(R.id.mRecyclerView);
        setUpToDos();

        ToDo_Adapter adapter =  new ToDo_Adapter(this.getContext(), theToDos);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        addButton =  view.findViewById(R.id.floatingActionButton);

                addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewList.newInsatnce().show(getFragmentManager() , AddNewList.TAG);
            }
        });


    }


    //grabbing values form strings array/test and adding them to the arraylist defined above
    private void setUpToDos() {
        String[] toDosName =  getResources().getStringArray(R.array.todolisttest);

        for (int i = 0; i<toDosName.length; i++) {
            theToDos.add(new ToDoListModel(toDosName[i]));
        }
    }
}
