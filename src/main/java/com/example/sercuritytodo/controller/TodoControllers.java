package com.example.sercuritytodo.controller;

import com.example.sercuritytodo.model.MyUser;
import com.example.sercuritytodo.model.Todo;
import com.example.sercuritytodo.service.TodoSerivec;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todo")
@RequiredArgsConstructor
public class TodoControllers {
    private final TodoSerivec todoSerivec;
@GetMapping("/getAll")
    public List<Todo> todoList(@AuthenticationPrincipal MyUser myUser){
        return todoSerivec.getAll(myUser.getId());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Todo todo,@AuthenticationPrincipal MyUser myUser){
    Boolean res=todoSerivec.update(id,todo,myUser);
    if(!res){
        return ResponseEntity.status(400).body("The id is not correct");
    }
    return ResponseEntity.status(200).body("Update Done");
    }
    @PostMapping("/add")
    public ResponseEntity addToto(@RequestBody @Valid Todo todo,@AuthenticationPrincipal MyUser user){
      todoSerivec.addToto(user.getId(),todo);
      return ResponseEntity.status(200).body("Added done");
    }
}
