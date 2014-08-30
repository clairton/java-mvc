package br.eti.clairton.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Tipo extends AbstractModel {
	private static final long serialVersionUID = 1L;

	private String nome;

	@OneToMany(mappedBy = "tipo")
	private List<Produto> produtos = new ArrayList<Produto>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}

	public void addProduto(Produto produto) {
		produtos.add(produto);
	}

	public void removeProduto(Produto produto) {
		produtos.remove(produto);
	}
}
