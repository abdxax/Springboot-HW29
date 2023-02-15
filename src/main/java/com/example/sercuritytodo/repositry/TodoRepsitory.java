package com.example.sercuritytodo.repositry;

import com.example.sercuritytodo.model.MyUser;
import com.example.sercuritytodo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepsitory extends JpaRepository<Todo,Integer> {
    //List<Todo> findTodoByUser_idEquals(Integer id);
    List<Todo> findByUserId(Integer user_id);
    Todo findByIdEquals(Integer id);

    List<Todo> findAllByUser(MyUser myUser);

    Todo findTodoById(Integer id);
}
