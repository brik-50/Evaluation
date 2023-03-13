package com.example.test2.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    @Column(length = 10)
    private String name;
    @Column(length = 25)
    private String adressEmail;



    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL )
    private Set<Projet> projets = new HashSet<>();



}
