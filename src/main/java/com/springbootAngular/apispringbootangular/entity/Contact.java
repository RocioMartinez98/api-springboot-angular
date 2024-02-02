package com.springbootAngular.apispringbootangular.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String nombre;
    @NonNull
    private String email;
    @NonNull
    private LocalDateTime createrAt; //Fecha de creacion


}