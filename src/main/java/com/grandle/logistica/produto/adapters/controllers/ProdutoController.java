package com.grandle.logistica.produto.adapters.controllers;

import com.grandle.logistica.produto.domain.entities.Produto;
import com.grandle.logistica.produto.domain.usecases.ListarProdutosUseCase;
import com.grandle.logistica.produto.infrastructure.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    private final ProdutoService produtoService; // Usar o serviço em vez do repositório
    private final ListarProdutosUseCase listarProdutosUseCase; // Usando o caso de uso

    @Autowired
    public ProdutoController(ListarProdutosUseCase listarProdutosUseCase, ProdutoService produtoService) {
        this.listarProdutosUseCase = listarProdutosUseCase;
        this.produtoService = produtoService;
    }

    @GetMapping
    public Page<Produto> listarProdutos(@RequestParam(required = false) String nome, Pageable pageable) {
        return listarProdutosUseCase.execute(nome, pageable); // Chama o caso de uso para listar produtos
    }

    @PostMapping
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.adicionarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto); // Retorna 201
    }

    @GetMapping("/{id}")
    public Produto obterProduto(@PathVariable Long id) {
        return produtoService.obterProduto(id); // Busca o produto pelo ID no serviço
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto); // Atualiza o produto no serviço
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.removerProduto(id); // Lógica para deletar o produto
        return ResponseEntity.noContent().build(); // Retorna 204
    }
}