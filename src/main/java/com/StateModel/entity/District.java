package com.StateModel.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "districtmodel",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_state_code",
                        columnNames = { "state_id", "code" }
                )
        }
)
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;
}
