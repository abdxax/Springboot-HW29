package com.example.sercuritytodo.service;

import com.example.sercuritytodo.model.MyUser;
import com.example.sercuritytodo.repositry.AuthRepstory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final AuthRepstory authRepstory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user=authRepstory.findMyUserByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("The user name or password is not correct");
        }
        return user;
    }


}
