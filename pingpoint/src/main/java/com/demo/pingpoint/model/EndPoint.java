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
@Table(name="endpoints")
public class EndPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // e.g. "/news", "/sports"

    @OneToMany(mappedBy = "endpoint", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Post> updates = new ArrayList<>();

    @ManyToMany(mappedBy = "subscribedEndpoints")
    @Builder.Default
    private Set<Person> subscribers = new HashSet<>();
}
