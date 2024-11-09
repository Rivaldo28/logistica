package com.grandle.logistica.produto.domain.usecases;


import com.grandle.logistica.produto.domain.entities.Produto;
import com.grandle.logistica.produto.infrastructure.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ListarProdutosUseCase {

    private final ProdutoService produtoService;

    public ListarProdutosUseCase(ProdutoService produtoService) {
        this.produtoService = produtoService; // Injeção do repositório
    }

    public Page<Produto> execute(String nome, Pageable pageable) {
        // Chama o método de listagem do repositório, usando a especificação
        return produtoService.listarProdutos(nome, pageable);
    }

}