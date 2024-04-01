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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String locName;

    @ElementCollection
    private List<EmbededCollection> embededCollections = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        this.users.add(user);
    }

    public void changeUser(List<User> users) {
        this.users = users;
    }

    @Builder
    public Location(String locName, List<User> users) {
        this.locName = locName;
        this.users = users;
    }

    public void updateLocationCodes(List<EmbededCollection> embededCollections) {
        this.embededCollections = embededCollections;
    }
}
