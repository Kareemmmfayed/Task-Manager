package com.learning.task_manager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

//    @Enumerated(EnumType.STRING)
//    private Role role;

//    @OneToMany(mappedBy = "assignedUser", cascade = CascadeType.ALL)
//    private List<Task> assignedTasks;

}
