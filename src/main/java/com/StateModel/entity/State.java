package com.StateModel.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "statemodel",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_state_code", columnNames = "code")
        }
)
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private String code;
}

