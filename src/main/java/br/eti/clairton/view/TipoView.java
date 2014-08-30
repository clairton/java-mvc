package br.eti.clairton.view;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.eti.clairton.controller.TipoController;
import br.eti.clairton.model.Tipo;

@ManagedBean
@ViewScoped
public class TipoView extends AbstractView<Tipo, TipoController> {
	private static final long serialVersionUID = 1L;

	public TipoView() {
	}

	@EJB
	public void setController(TipoController controller) {
		this.controller = controller;
	}
}
