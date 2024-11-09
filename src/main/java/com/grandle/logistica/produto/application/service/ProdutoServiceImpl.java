package com.grandle.logistica.produto.application.service;

import com.grandle.logistica.produto.application.ports.ProdutoRepository;
import com.grandle.logistica.produto.domain.entities.Produto;
import com.grandle.logistica.produto.domain.specifications.ProdutoSpecification;
import com.grandle.logistica.produto.infrastructure.ProdutoService; // Assegure-se de que isso é necessário
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService { // Confirme se ProdutoService é uma interface

    @Autowired
    private ProdutoRepository produtoRepository; // Repositório Spring Data

    @Override
    public Page<Produto> listarProdutos(String nome, Pageable pageable) {
        System.out.println("Parâmetro de nome: " + nome); // Log do parâmetro
        Specification<Produto> spec = ProdutoSpecification.nomeContains(nome);
        // Use findAll com a Specification e Pageable
        Page<Produto> produtos = produtoRepository.findAll(spec, pageable);
        System.out.println("Número de produtos encontrados: " + produtos.getTotalElements());
        return produtos;
    }

    @Override
    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto); // Usa save para adicionar ou atualizar
    }

    @Override
    public Produto obterProduto(Long id) {
        return produtoRepository.findById(id).orElse(null); // Retorna null se não encontrado
    }

    @Override
    public Produto atualizarProduto(Long id, Produto produto) {
        produto.setId(id); // Define o ID para a atualização
        return produtoRepository.save(produto); // Usa save para atualizar
    }

    @Override
    public void removerProduto(Long id) {
        produtoRepository.deleteById(id); // Remove o produto pelo ID
    }
}