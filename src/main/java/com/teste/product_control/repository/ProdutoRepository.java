package com.teste.product_control.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.product_control.model.Produto;
import com.teste.product_control.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepository {

	private List<Produto> produtos = new ArrayList<Produto>();
	private Integer ultimoId = 0;
	
	/**
	 * Método para retornar uma lista de produtos
	 * @return Lista de produtos
	 */
	public List<Produto> obterTodos(){
		return produtos;
	}
	
	/**
	 * Método que retorna o produto localizado pelo seu id.
	 * @param id do produto que será localizado.
	 * @return Retorna um produto caso tenha encontrado.
	 */
	public Optional<Produto> obterPorId(Integer id) {
		return produtos
				.stream()
				.filter(produto -> produto.getId() == id)
				.findFirst();
	}
	
	/**
	 * Método para adicionar um produto na lista
	 * @param produto
	 * @return
	 */
	public Produto adicionar(Produto produto) {
		ultimoId++;
		produto.setId(ultimoId);
		produtos.add(produto);
		
		return produto;
	}
	
	/**
	 * Método para deletar o produto por id.
	 * @param id do produto a ser deletado.
	 */
	public void deletar(Integer id) {
		produtos.removeIf(produto -> produto.getId() == id);
	}
	
	/**
	 * Método para atualizar o produto na lista,
	 * @param produto que será atualizado.
	 * @return Retorna o produto após atualizar a lista.
	 */
	public Produto atualizar(Produto produto) {
		// Encontra o produto na lista.
		Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
		
		if(produtoEncontrado.isEmpty()) {
			throw new ResourceNotFoundException("Produto inexistente");
		}
		
		// Remove produto antigo da lista.
		deletar(produto.getId());
		
		// Adiciona o produto atualizado na lista.
		produtos.add(produto);
		
		return produto;
		
	}
	
}
