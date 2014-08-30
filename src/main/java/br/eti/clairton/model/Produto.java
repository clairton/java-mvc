package br.eti.clairton.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Produto extends AbstractModel {
	private static final long serialVersionUID = 1L;

	private String nome;

	@ManyToOne
	private Tipo tipo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
