package com.example.sercuritytodo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String task;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userid",referencedColumnName = "id")
    @JsonIgnore
    private  MyUser user;
}
