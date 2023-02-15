package com.example.sercuritytodo.repositry;

import com.example.sercuritytodo.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepstory extends JpaRepository<MyUser,Integer> {
    MyUser findMyUserByUserName(String username);
    MyUser findByIdEquals(Integer id);
}
