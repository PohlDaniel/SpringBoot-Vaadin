package de.admera.ui.hybridmenu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.VaadinSession;

import de.admera.ui.hybridmenu.components.BreadCrumbs;
import de.admera.ui.hybridmenu.components.HMLabel;
import de.admera.ui.hybridmenu.components.LeftMenu;
import de.admera.ui.hybridmenu.components.NotificationCenter;
import de.admera.ui.hybridmenu.components.TopMenu;
import de.admera.ui.hybridmenu.data.DefaultViewChangeManager;
import de.admera.ui.hybridmenu.data.MenuConfig;
import de.admera.ui.hybridmenu.data.interfaces.HybridMenuRouter;
import de.admera.ui.hybridmenu.data.interfaces.MenuComponent;
import de.admera.ui.hybridmenu.data.interfaces.TopMenuButtons;
import de.admera.ui.hybridmenu.data.interfaces.ViewChangeManager;
import de.admera.ui.hybridmenu.utils.Styles;

@JsModule("./themes/HybridMenu/HybridMenu.js")
public abstract class HybridMenu extends VerticalLayout implements RouterLayout, AfterNavigationObserver, HybridMenuRouter {
	private static final long serialVersionUID = -4055770717384786366L;

	private ViewChangeManager viewChangeManager = new DefaultViewChangeManager();
	private MenuConfig config = null;
	private boolean buildRunning = false;

	/* Components */
	private BreadCrumbs breadCrumbs = null;
	private VerticalLayout mainContent = new VerticalLayout();
	private TopMenu topMenu = new TopMenu();
	private LeftMenu leftMenu = new LeftMenu();
	private NotificationCenter notificationCenter = new NotificationCenter();
	
	public ViewChangeManager getViewChangeManager() {
		return this.viewChangeManager;
	}
	
	public MenuConfig getConfig() {
		return this.config;
	}
	
	
	public VerticalLayout getMainContent() {
		return this.mainContent;
	}
	
	public TopMenu getTopMenu() {
		return this.topMenu;
	}
	
	public LeftMenu getLeftMenu() {
		return this.leftMenu;
	}
	
	public NotificationCenter getNotificationCenter() {
		return this.notificationCenter;
	}
	
	private List<Component> tempTopMenuComponents = new ArrayList<Component>();
	
	protected HybridMenu() {
		setSizeFull();
		getClassNames().add(Styles.hybridMenu);
		setMargin(false);
		setPadding(false);
		setSpacing(false);
		
		VaadinSession.getCurrent().setAttribute(MenuConfig.class, MenuConfig.builder().build());
		
		boolean build = init(VaadinSession.getCurrent(), UI.getCurrent());
		
		if (build) {
			build();
		}
	}

	public HybridMenu build() {
		if (!buildRunning) {
			this.setSizeFull();
			this.setMargin(false);
			this.setSpacing(false);
			this.getClassNames().add(Styles.rootContent);
			
			this.add(HMLabel.get().withCaption("<b>Admera</b>")
								  .withIcon(new Image("./frontend/HybridMenu/Images/Logo.png", "HybridMenu Logo")));
			this.add(topMenu);
			this.add(leftMenu);

			/*if (config.isBreadcrumbs()) {
				mainContent.add(getBreadCrumbs());
			}*/
			

			mainContent.setWidth("100%");
			mainContent.setHeight("100%");
			mainContent.setMargin(false);
			mainContent.setPadding(false);
			mainContent.setSpacing(false);
			mainContent.setClassName("mainContent");
	
			this.add(mainContent);

			notificationCenter.setNotificationPosition(config.getNotificationPosition());
			
			VaadinSession.getCurrent().setAttribute(MenuConfig.class, config);
			VaadinSession.getCurrent().setAttribute(HybridMenu.class, this);
			buildRunning = true;
		}
		return this;
	}
	
	public BreadCrumbs getBreadCrumbs() {
		if (breadCrumbs == null) {
			breadCrumbs = new BreadCrumbs();
		}
		
		return breadCrumbs;
	}

	public HybridMenu withConfig(MenuConfig config) {
		VaadinSession.getCurrent().setAttribute(MenuConfig.class, config);
		this.config = config;
		return this;
	}

	public void setViewChangeManager(ViewChangeManager viewChangeManager) {
		this.viewChangeManager = viewChangeManager;
	}
	
	@Override
	public void showRouterLayoutContent(HasElement content) {
		clearTempTopMenu();
        if (content != null) {
        	Component component = content.getElement().getComponent().get();
        	
        	content.getElement().getStyle().set("width", "100%");
        	content.getElement().getClassList().add(Styles.contentBox);
        	
        	if (!config.isBreadcrumbs()) {
        		component.getElement().getClassList().add(Styles.paddingTopContent);
			}
        	
        	this.mainContent.add(component);
        	this.mainContent.expand(component);
        	
        	if (component instanceof TopMenuButtons) {
        		setTempTopMenu((TopMenuButtons) component); 
        	}
        }
    }
	
	private void setTempTopMenu(TopMenuButtons topMenuButtons) {
		tempTopMenuComponents = topMenuButtons.topMenuButtons(tempTopMenuComponents);
		for (Component component : tempTopMenuComponents) {
			topMenu.add(component);
		}
	}
	
	private void clearTempTopMenu() {
		for (Component component : tempTopMenuComponents) {
			topMenu.remove(component);
		}
		tempTopMenuComponents.clear();
	}

	@Override
	public void afterNavigation(AfterNavigationEvent event) {
		List<MenuComponent<?>> menuContentList = viewChangeManager.init(HybridMenu.this);
		viewChangeManager.manage(HybridMenu.this, leftMenu, event, menuContentList);
		viewChangeManager.manage(HybridMenu.this, topMenu, event, menuContentList);
		viewChangeManager.finish(HybridMenu.this, menuContentList);
	}
	
	public static String fileToString(File file) {
		StringBuilder result = new StringBuilder("");

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return result.toString();
	}
	
	public static InputStream fileToInputStream(File file) throws FileNotFoundException {
		return new FileInputStream(file);
	}
	
	public static File getFile(String fileName) {
		return new File(HybridMenu.class.getClassLoader().getResource(fileName).getFile());
	}
}