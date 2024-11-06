package com.teste.product_control.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.product_control.model.Produto;
import com.teste.product_control.repository.ProdutoRepository;

@Service
public class ProdutoSevice {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	/**
	 * Método para retornar uma lista de produtos
	 * @return Lista de produtos
	 */
	public List<Produto> obterTodos(){
		return produtoRepository.obterTodos();
	}
	
	/**
	 * Método que retorna o produto localizado pelo seu id.
	 * @param id do produto que será localizado.
	 * @return Retorna um produto caso tenha encontrado.
	 */
	public Optional<Produto> obterPorId(Integer id) {
		return produtoRepository.obterPorId(id);
	}
	
	/**
	 * Método para adicionar um produto na lista
	 * @param produto
	 * @return
	 */
	public Produto adicionar(Produto produto) {
		return produtoRepository.adicionar(produto);
	}
	
	/**
	 * Método para deletar o produto por id.
	 * @param id do produto a ser deletado.
	 */
	public void deletar(Integer id) {
		produtoRepository.deletar(id);
	}
	
	public Produto atualizar(Integer id, Produto produto) {
		produto.setId(id);
		return produtoRepository.atualizar(produto);
	}
	
}
