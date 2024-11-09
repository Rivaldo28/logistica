package com.grandle.logistica.produto.infrastructure;

import com.grandle.logistica.produto.domain.entities.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoService {
    Page<Produto> listarProdutos(String nome, Pageable pageable);
    Produto adicionarProduto(Produto produto);
    Produto obterProduto(Long id);
    Produto atualizarProduto(Long id, Produto produto);
    void removerProduto(Long id);
}