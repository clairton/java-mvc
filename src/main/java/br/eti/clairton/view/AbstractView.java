package br.eti.clairton.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import br.eti.clairton.controller.AbstractController;
import br.eti.clairton.model.AbstractModel;

public class AbstractView<M extends AbstractModel, T extends AbstractController<M>>
		implements Serializable {
	private static final long serialVersionUID = 1L;
	protected T controller;
	protected M model;
	private Boolean novo = Boolean.TRUE;

	@PostConstruct
	public void criar() {
		model = controller.novo();
		novo = Boolean.TRUE;
	}

	public void salvar() {
		if (novo) {
			model = controller.salvar(model);
		} else {
			model = controller.alterar(model);
		}
		novo = Boolean.FALSE;
	}

	public void editar(M model) {
		this.model = model;
		novo = Boolean.FALSE;
	}

	public void remover(M model) {
		controller.remover(model);
		criar();
	}

	public List<M> listar() {
		return controller.listar();
	}

	public M getModel() {
		return model;
	}

	public void setModel(M model) {
		this.model = model;
	}
}
