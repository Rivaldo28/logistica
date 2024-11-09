package com.grandle.logistica.produto.domain.entities;

import com.grandle.logistica.produto.domain.enums.Categoria;
import jakarta.persistence.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "quantidade")
    private int quantidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private Categoria categoria;

}
