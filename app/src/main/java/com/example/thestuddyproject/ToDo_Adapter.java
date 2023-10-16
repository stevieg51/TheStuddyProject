package com.example.thestuddyproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thestuddyproject.datamodels.ToDoListModel;

import java.util.ArrayList;

public class ToDo_Adapter extends RecyclerView.Adapter<ToDo_Adapter.MyViewHolder> {

    //context needed for inflating layout
    Context context;
    ArrayList<ToDoListModel> todos;

    public ToDo_Adapter(Context context, ArrayList<ToDoListModel> todos) {
        this.context = context;
        this.todos = todos;
    }
    @NonNull
    @Override
    public ToDo_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating layout (giving look to each row)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new ToDo_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDo_Adapter.MyViewHolder holder, int position) {
    //assigning values to each row as they come back on screen in recycler view
    holder.toDoName.setText(todos.get(position).getTodoname());

    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
    //grabbing all of the view from the todolist_layout
    //kinda like a onCreate method
        TextView toDoName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            toDoName = itemView.findViewById(R.id.recyclerRowText);

        }
    }
}
