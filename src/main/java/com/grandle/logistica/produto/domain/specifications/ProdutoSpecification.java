package com.grandle.logistica.produto.domain.specifications;


import com.grandle.logistica.produto.domain.entities.Produto;
import org.springframework.data.jpa.domain.Specification;

public class ProdutoSpecification {
    public static Specification<Produto> nomeContains(String nome) {
        return (root, query, criteriaBuilder) -> {
            if (nome == null || nome.isEmpty()) {
                return criteriaBuilder.conjunction(); // Retorna todas as linhas
            }
            return criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
        };
    }
}