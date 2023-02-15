package com.example.sercuritytodo;

import com.example.sercuritytodo.model.MyUser;
import com.example.sercuritytodo.repositry.AuthRepstory;
import com.example.sercuritytodo.service.AuthService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @InjectMocks
    AuthService authService;
    @Mock
    AuthRepstory authRepstory;

    List<MyUser> userList;
    MyUser user1,user2,user3,user4;

    @BeforeEach
    void setUp() {
        user1=new MyUser(null,"Ahmad","123456","ADMIN",null);
        user2=new MyUser(null,"Ali","123456","USER",null);
        user3=new MyUser(null,"Khaled","123456","USER",null);
        user4=new MyUser(null,"Fahad","123456","USER",null);

        userList=new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

    }
    @Test
    public void getAllTest(){
        when(authRepstory.findAll()).thenReturn(userList);
        List<MyUser> userList1=authService.users();
        Assertions.assertEquals(4,userList1.size());
        verify(authRepstory,times(1)).findAll();
    }
@Test
    public void registerTest(){
        MyUser u=new MyUser(null,"Test","123456","Admin",null);
        authService.register(u);
        verify(authRepstory,times(1)).save(u);

    }
    @Test
    public void updateTest(){
        when(authRepstory.findByIdEquals(user1.getId())).thenReturn(user1);
        authService.update(user1.getId(),user1);
        verify(authRepstory,times(1)).findByIdEquals(user1.getId());
        verify(authRepstory,times(1)).save(user1);
    }
    @Test
    public void deleteTest(){
        when(authRepstory.findByIdEquals(user2.getId())).thenReturn(user2);
        authService.delete(user2.getId());
        verify(authRepstory,times(1)).delete(user2);
    }



}
