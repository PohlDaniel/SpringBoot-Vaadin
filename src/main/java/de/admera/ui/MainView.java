package de.admera.ui;

import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;


import de.admera.ui.hybridmenu.HybridMenu;
import de.admera.ui.hybridmenu.components.HMButton;
import de.admera.ui.hybridmenu.components.HMSubMenu;
import de.admera.ui.hybridmenu.components.HMTextField;
import de.admera.ui.hybridmenu.components.LeftMenu;
import de.admera.ui.hybridmenu.components.TopMenu;
import de.admera.ui.hybridmenu.data.MenuConfig;
import de.admera.ui.pages.AdminPage;
import de.admera.ui.pages.GroupPage;
import de.admera.ui.pages.HomePage;
import de.admera.ui.pages.MemberPage;
import de.admera.ui.pages.NotificationBuilderPage;
import de.admera.ui.pages.SettingsPage;
import de.admera.ui.pages.UserPage;

@Route("mainView")
@Secured("ROLE_User")
@Push
@Theme(Lumo.class)
@BodySize(height = "100vh", width = "100vw")
public class MainView extends HybridMenu{

	private static final long serialVersionUID = 2766167599243004212L;

	@Override
	public boolean init(VaadinSession vaadinSession, UI ui) {
		withConfig(MenuConfig.builder().build());

		TopMenu topMenu = getTopMenu();
		
		topMenu.add(HMTextField.get(VaadinIcon.SEARCH, "Search ...")
					.withThemeName("tmTextField"));
		
		topMenu.add(HMButton.get()
				.withIcon(VaadinIcon.HOME)
				.withDescription("Home")
				.withThemeName("tmButton")
				.withNavigateTo(HomePage.class));
		
		getNotificationCenter()
				.setNotiButton(topMenu.add(HMButton.get()
						.withDescription("Notifications")
						.withThemeName("tmButton")));
		
		/*topMenu.add(HMButton.get()
				.withIcon(VaadinIcon.BELL)
				.withDescription("Notifications")
				.withThemeName("tmButton"));*/
		
		LeftMenu leftMenu = getLeftMenu();
		
		
		
		getBreadCrumbs().setRoot(leftMenu.add(HMButton.get()
				.withCaption("Home")
				.withIcon(VaadinIcon.HOME)
				.withThemeName("hmButton")
				.withThemeName("lmButton")
				.withToggleBetweenClasses("stateOne", "stateTwo")
				.withNavigateTo(HomePage.class)));

		leftMenu.add(HMButton.get()
				.withCaption("Notification Builder")
				.withIcon(VaadinIcon.BELL)
				.withThemeName("hmButton")
				.withThemeName("lmButton")
				.withToggleBetweenClasses("stateOne", "stateTwo")
				.withNavigateTo(NotificationBuilderPage.class));

		HMSubMenu memberList = leftMenu.add(HMSubMenu.get()
				.withCaption("Menu")
				.withIcon(VaadinIcon.USERS));
		
		memberList.add(HMButton.get()
				.withCaption("Settings")
				.withIcon(VaadinIcon.COGS)
				.withThemeName("hmButton")
				.withThemeName("lmButton")
				.withToggleBetweenClasses("stateOne", "stateTwo")
				.withNavigateTo(SettingsPage.class));
		
		memberList.add(HMButton.get()
				.withCaption("Member")
				.withIcon(VaadinIcon.USERS)
				.withThemeName("hmButton")
				.withThemeName("lmButton")
				.withToggleBetweenClasses("stateOne", "stateTwo")
				.withNavigateTo(MemberPage.class));
		
		memberList.add(HMButton.get()
				.withCaption("Group")
				.withIcon(VaadinIcon.USERS)
				.withThemeName("hmButton")
				.withThemeName("lmButton")
				.withToggleBetweenClasses("stateOne", "stateTwo")
				.withNavigateTo(GroupPage.class));

		HMSubMenu memberListTwo = memberList.add(HMSubMenu.get()
				.withCaption("SubMenu")
				.withIcon(VaadinIcon.USERS));

		memberListTwo.add(HMButton.get()
				.withCaption("Admin Page")
				.withIcon(VaadinIcon.COGS)
				.withThemeName("hmButton")
				.withThemeName("lmButton")
				.withToggleBetweenClasses("stateOne", "stateTwo")
				.withNavigateTo(AdminPage.class));
		
		memberListTwo.add(HMButton.get()
				.withCaption("User Page")
				.withIcon(VaadinIcon.USERS)
				.withThemeName("hmButton")
				.withThemeName("lmButton")
				.withToggleBetweenClasses("stateOne", "stateTwo")
				.withNavigateTo(UserPage.class));


		HMSubMenu demoSettings = leftMenu.add(HMSubMenu.get()
				.withCaption("Settings")
				.withIcon(VaadinIcon.COGS));
		
		demoSettings.add(HMButton.get()
				.withCaption("White Theme")
				.withIcon(VaadinIcon.PALETE)
				.withThemeName("hmButton")
				.withThemeName("lmButton")
				.withClickListener(e -> UI.getCurrent().getElement().setAttribute("theme", "")));

		demoSettings.add(HMButton.get()
				.withCaption("Dark Theme")
				.withIcon(VaadinIcon.PALETE)
				.withThemeName("hmButton")
				.withThemeName("lmButton")
				.withClickListener(e -> UI.getCurrent().getElement().setAttribute("theme", Lumo.DARK)));
		
		demoSettings.add(HMButton.get()
				.withCaption("Minimal")
				.withIcon(VaadinIcon.COG)
				.withThemeName("hmButton")
				.withThemeName("lmButton")
				.withClickListener(e -> getLeftMenu().toggleSize()));
		
		return true
; // build menu
	}
}
