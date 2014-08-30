package br.eti.clairton.view;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.eti.clairton.controller.ProdutoController;
import br.eti.clairton.model.Produto;

@ManagedBean
@ViewScoped
public class ProdutoView extends AbstractView<Produto, ProdutoController> {
	private static final long serialVersionUID = 1L;

	public ProdutoView() {
	}

	@EJB
	public void setController(ProdutoController controller) {
		this.controller = controller;
	}
}
