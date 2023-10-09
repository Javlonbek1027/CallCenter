package com.example.benom.example.model.entity;

import com.example.benom.example.model.enums.Regions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EducationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    private Regions region;

    
}
