package com.example.thestuddyproject.datamodels;

public class ToDoListModel {

    private String todoname;


    public ToDoListModel(String todoname) {
        this.todoname = todoname;
    }

    public String getTodoname() {
        return todoname;
    }

    public void setTodoname(String todoname) {
        this.todoname = todoname;
    }
}
