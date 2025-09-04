package com.demo.pingpoint.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private List<Post> updates = new ArrayList<>();

    @ManyToMany(mappedBy = "subscribedEndpoints")
    @Builder.Default
    @JsonIgnore
    private Set<Person> subscribers = new HashSet<>();
}
