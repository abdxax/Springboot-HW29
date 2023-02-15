package com.example.sercuritytodo.service;

import com.example.sercuritytodo.model.MyUser;
import com.example.sercuritytodo.repositry.AuthRepstory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
     private final AuthRepstory authRepstory;

    public List<MyUser> users() {
        return authRepstory.findAll();
    }

    public void register(MyUser myUser) {
        String pass=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(pass);
        myUser.setRole("user");
        authRepstory.save(myUser);
    }

    public Boolean update (Integer id,MyUser user){
        MyUser user1=authRepstory.findByIdEquals(id);
        if(user1==null){
            return false;
        }
        user.setId(user1.getId());
        user.setTodoList(user1.getTodoList());
        authRepstory.save(user);
        return true;
    }

    public Boolean delete (Integer id){
        MyUser user1=authRepstory.findByIdEquals(id);
        if(user1==null){
            return false;
        }

        authRepstory.delete(user1);
        return true;
    }
}
