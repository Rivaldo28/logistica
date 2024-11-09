package com.grandle.logistica.produto.adapters.converters;

import com.grandle.logistica.produto.adapters.presenters.ProdutoPresenter;
import com.grandle.logistica.produto.domain.entities.Produto;

public class ProdutoConverter {

    public static ProdutoPresenter toPresenter(Produto produto) {
        ProdutoPresenter presenter = new ProdutoPresenter();
        presenter.setId(produto.getId());
        presenter.setNome(produto.getNome());
        presenter.setQuantidade(produto.getQuantidade());
        return presenter;
    }

    public static Produto toEntity(ProdutoPresenter presenter) {
        Produto produto = new Produto();
//        produto.setId(presenter.getId());
        produto.setNome(presenter.getNome());
        produto.setQuantidade(presenter.getQuantidade());
        return produto;
    }
}