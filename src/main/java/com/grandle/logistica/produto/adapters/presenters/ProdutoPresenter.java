package com.grandle.logistica.produto.adapters.presenters;

import lombok.Data;

@Data
public class ProdutoPresenter {
    private Long id;
    private String nome;
    private Integer quantidade;
}