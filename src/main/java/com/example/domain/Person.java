package com.example.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String personName;

    @OneToMany(fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    @Builder
    public Person(String personName) {
        this.personName = personName;
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
