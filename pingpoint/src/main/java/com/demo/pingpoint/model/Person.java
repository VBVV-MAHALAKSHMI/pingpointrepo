package com.demo.pingpoint.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String email;

    // One user can post many updates
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Post> posts = new ArrayList<>();

    // Many users can subscribe to many endpoints
    @ManyToMany
    @JoinTable(
            name = "person_endpoints",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "endpoint_id")
    )
    @Builder.Default
    private Set<EndPoint> subscribedEndpoints = new HashSet<>();
}
