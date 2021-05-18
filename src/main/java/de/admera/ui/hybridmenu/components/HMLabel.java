package de.admera.ui.hybridmenu.components;

import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.dom.Element;

import de.admera.ui.hybridmenu.data.interfaces.MenuComponent;

/**
 * Only for the left menu
 */
@JsModule("./themes/HybridMenu/HMLabel.js")
@SuppressWarnings("hiding")
public class HMLabel extends Label implements MenuComponent<HMLabel> {
	private static final long serialVersionUID = -1030806788859361123L;

	private Element caption = null;
	private Element icon = null;
	
	public HMLabel() {
		super();
		this.setWidth("100%");
		this.setHeight("100%");
		getClassNames().add("hmLabel");
	}
	
	
	public static HMLabel get() {
		return new HMLabel();
	}
	
	public HMLabel withCaption(String caption) {
		if (this.caption != null) {
			getElement().removeChild(this.caption);
		}
		if (caption != null) {
			this.caption = getElement().appendChild(new Html("<p>" + caption + "</p>").getElement());
		}
		return this;
	}
	
	public HMLabel withIcon(VaadinIcon icon) {
		return withIcon(icon.create());
	}
	
	public HMLabel withIcon(Component icon) {
		if (this.icon != null) {
			getElement().removeChild(this.icon);
		}
		if (icon != null) {
			this.icon = getElement().insertChild(0, icon.getElement());
		}
		return this;
	}
	
	public HMLabel withStyleName(String style) {	
		getClassNames().add(style);
		return this;
	}
	
	@Override
	public <MenuComponent extends Component> MenuComponent add(MenuComponent c) {
		return null;
	}

	@Override
	public <MenuComponent extends Component> MenuComponent addAsFirst(MenuComponent c) {
		return null;
	}

	@Override
	public <MenuComponent extends Component> MenuComponent addAt(MenuComponent c, int index) {
		return null;
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public <MenuComponent extends Component> HMLabel remove(MenuComponent c) {
		return null;
	}

	@Override
	public List<MenuComponent<?>> getList() {
		return null;
	}
}