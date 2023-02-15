package com.example.sercuritytodo.service;

import com.example.sercuritytodo.model.MyUser;
import com.example.sercuritytodo.model.Todo;
import com.example.sercuritytodo.repositry.AuthRepstory;
import com.example.sercuritytodo.repositry.TodoRepsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoSerivec {
    private final TodoRepsitory todoRepsitory;
    private final AuthRepstory authRepstory;

    public void addToto(Integer id,Todo todo)
    {
        MyUser user=authRepstory.getById(id);
        todo.setUser(user);
       todoRepsitory.save(todo);
    }

    public List<Todo> getAll(Integer userId){
        return todoRepsitory.findByUserId(userId);
    }

    public Boolean update(Integer id,Todo todos, MyUser myUser){
        Todo todo=todoRepsitory.findByIdEquals(id);
        if(todo==null||todo.getUser().getId()!=myUser.getId()){
            return false;
        }
        todos.setUser(todo.getUser());
        todos.setId(todo.getId());
        todoRepsitory.save(todos);
        return true;

    }

    public List<Todo> getAllTodoUser(Integer id){
        MyUser user=authRepstory.getById(id);
        List<Todo> todoList=todoRepsitory.findAllByUser(user);
        return todoList;
    }
}
