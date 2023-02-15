package com.example.sercuritytodo;

import com.example.sercuritytodo.model.MyUser;
import com.example.sercuritytodo.model.Todo;
import com.example.sercuritytodo.repositry.AuthRepstory;
import com.example.sercuritytodo.repositry.TodoRepsitory;
import com.example.sercuritytodo.service.TodoSerivec;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {
    @InjectMocks
    TodoSerivec todoSerivec;
    @Mock
     TodoRepsitory todoRepsitory;
      MyUser user;
      Todo todo1,todo2,todo3,todo4;
      List<Todo> todoList;

    @BeforeEach
    void setUp() {
        user=new MyUser(null,"ali","123456","ADMIN",null);
        todo1=new Todo(null,"Todo1",user);
        todo2=new Todo(null,"Todo2",user);
        todo3=new Todo(null,"todo3",null);
        todoList=new ArrayList<>();
        todoList.add(todo1);
        todoList.add(todo2);
        todoList.add(todo3);
    }
@Test
    public void getAllTest(){
        when(todoRepsitory.findByUserId(user.getId())).thenReturn(todoList);
    Assertions.assertEquals(todoList,todoSerivec.getAll(user.getId()));

    }
}
