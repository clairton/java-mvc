package br.eti.clairton.view.converters;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.selectonemenu.SelectOneMenu;

import br.eti.clairton.model.Tipo;

@FacesConverter(forClass = Tipo.class, value = "tipo")
public class TipoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value == null || value.isEmpty()) {
			return new Tipo();
		}
		SelectOneMenu selectOneMenu = (SelectOneMenu) component;
		Tipo tipo = new Tipo();
		UIComponent children = selectOneMenu.getChildren().get(0);
		UISelectItems items = (UISelectItems) children;
		@SuppressWarnings("unchecked")
		List<Tipo> tipos = (List<Tipo>) items.getValue();
		for (Tipo t : tipos) {
			if (t.getId().toString().equals(value)) {
				tipo = t;
				break;
			}
		}
		return tipo;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null) {
			return "";
		}
		Tipo tipo = (Tipo) value;
		return tipo.getId().toString();
	}

}
