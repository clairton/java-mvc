package br.eti.clairton.controller;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.eti.clairton.model.Tipo;

@LocalBean
@Stateless
public class TipoController extends AbstractController<Tipo> {
	private static final long serialVersionUID = 1L;

	@Override
	public Tipo novo() {
		return new Tipo();
	}

}
