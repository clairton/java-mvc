package br.eti.clairton.controller;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.eti.clairton.model.Produto;

@LocalBean
@Stateless
public class ProdutoController extends AbstractController<Produto> {
	private static final long serialVersionUID = 1L;

	@Override
	public Produto novo() {
		return new Produto();
	}
}
