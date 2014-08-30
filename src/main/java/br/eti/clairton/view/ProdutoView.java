package br.eti.clairton.view;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.eti.clairton.controller.ProdutoController;
import br.eti.clairton.controller.TipoController;
import br.eti.clairton.model.Produto;

@ManagedBean
@ViewScoped
public class ProdutoView extends AbstractView<Produto, ProdutoController> {
	private static final long serialVersionUID = 1L;

	private Integer idTipo;

	@EJB
	private TipoController tipoController;

	public ProdutoView() {
	}

	@EJB
	public void setController(ProdutoController controller) {
		this.controller = controller;
	}

	@Override
	public void salvar() {
		getModel().setTipo(tipoController.pesquisar(idTipo));
		super.salvar();
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}
}
