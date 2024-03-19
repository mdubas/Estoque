package com.uninter.estoque.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(length = 11)
    private String cpf;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_nascimento")
    private LocalDate dataDeNascimento;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Column(length = 10)
    private String telefone;
    @Column(length = 11)
    private String celular;
    @Column(length = 50)
    private String email;
    private boolean ativo;



}
