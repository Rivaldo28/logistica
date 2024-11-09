package com.grandle.logistica.estoque.adapters.controllers;

import com.grandle.logistica.produto.adapters.controllers.ProdutoController;
import com.grandle.logistica.produto.domain.entities.Produto;
import com.grandle.logistica.produto.domain.enums.Categoria;
import com.grandle.logistica.produto.domain.usecases.ListarProdutosUseCase;
import com.grandle.logistica.produto.infrastructure.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class ProdutoControllerTest {
    @InjectMocks
    private ProdutoController produtoController;

    @Mock
    private ProdutoService produtoService;

    @Mock
    private ListarProdutosUseCase listarProdutosUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarProdutos() {
        Produto produto = new Produto(); // Usando o construtor padrão
        produto.setId(1L);
        produto.setNome("Produto Teste");
        produto.setQuantidade(10);
        produto.setCategoria(Categoria.valueOf("ELETRONICOS"));

        Page<Produto> paginaProdutos = new PageImpl<>(Collections.singletonList(produto));
        when(listarProdutosUseCase.execute(any(), any(Pageable.class))).thenReturn(paginaProdutos);

        Page<Produto> resultado = produtoController.listarProdutos(null, Pageable.unpaged());

        assertEquals(1, resultado.getTotalElements());
        assertEquals("Produto Teste", resultado.getContent().get(0).getNome());
    }

    @Test
    void testAdicionarProduto() {
        Produto produto = new Produto(); // Usando o construtor padrão
        produto.setId(1L);
        produto.setNome("Produto Teste");
        produto.setQuantidade(10);
        produto.setCategoria(Categoria.valueOf("ELETRONICOS"));

        when(produtoService.adicionarProduto(any(Produto.class))).thenReturn(produto);

        ResponseEntity<Produto> response = produtoController.adicionarProduto(produto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Produto Teste", response.getBody().getNome());
    }

    @Test
    void testObterProduto() {
        Produto produto = new Produto(); // Usando o construtor padrão
        produto.setId(1L);
        produto.setNome("Produto Teste");
        produto.setQuantidade(10);
        produto.setCategoria(Categoria.valueOf("ELETRONICOS"));

        when(produtoService.obterProduto(anyLong())).thenReturn(produto);

        Produto resultado = produtoController.obterProduto(1L);

        assertEquals("Produto Teste", resultado.getNome());
    }

    @Test
    void testAtualizarProduto() {
        Produto produtoAtualizado = new Produto(); // Usando o construtor padrão
        produtoAtualizado.setId(1L);
        produtoAtualizado.setNome("Produto Atualizado");
        produtoAtualizado.setQuantidade(15);
        produtoAtualizado.setCategoria(Categoria.valueOf("ELETRONICOS"));

        when(produtoService.atualizarProduto(anyLong(), any(Produto.class))).thenReturn(produtoAtualizado);

        Produto resultado = produtoController.atualizarProduto(1L, produtoAtualizado);

        assertEquals("Produto Atualizado", resultado.getNome());
        assertEquals(15, resultado.getQuantidade());
    }

    @Test
    void testDeletarProduto() {
        doNothing().when(produtoService).removerProduto(anyLong());

        ResponseEntity<Void> response = produtoController.deletarProduto(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}