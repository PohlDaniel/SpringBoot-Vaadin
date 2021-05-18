package de.admera.ui.hybridmenu.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import de.admera.ui.hybridmenu.data.interfaces.MenuComponent;
import de.admera.ui.hybridmenu.utils.Styles;

@JsModule("./themes/HybridMenu/TopMenu.js")
@SuppressWarnings("hiding")
public class TopMenu extends HorizontalLayout implements MenuComponent<TopMenu> {
	private static final long serialVersionUID = -1591746194262213773L;
	
	public TopMenu() {
		super();
		this.setWidth("100%");
		this.setHeight("100%");
		getClassNames().add(Styles.topMenu);
		setMargin(false);
		setSpacing(false);	
	}
	
	public <MenuComponent extends Component> MenuComponent add(MenuComponent c) {
		if (c instanceof HasStyle) {
			((HasStyle) c).getClassNames().add(Styles.topMenuItem);
		}
		super.add(c);
		return c;
	}
	
	@Override
	public <MenuComponent extends Component> MenuComponent addAsFirst(MenuComponent c) {
		//super.addAsFirst(c);
		return c;
	}

	@Override
	public <MenuComponent extends Component> MenuComponent addAt(MenuComponent c, int index) {
		//super.addAt(c, index);
		return c;
	}
	
	@Override
	public int count() {
		return getList().size();
	}
	
	@Override
	public <MenuComponent extends Component> TopMenu remove(MenuComponent c) {
		super.remove(c);
		return this;
	}
	
	@Override
	public List<MenuComponent<?>> getList() {
		List<MenuComponent<?>> menuComponentList = new ArrayList<MenuComponent<?>>();
		for (int i = 0; i < getComponentCount(); i++) {
			Component component = getComponentAt(i);
			if (component instanceof MenuComponent<?>) {
				menuComponentList.add((MenuComponent<?>) component);
			}
		}
		return menuComponentList;
	}
}