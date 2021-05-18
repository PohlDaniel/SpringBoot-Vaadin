package de.admera.ui.hybridmenu.data.builder;

import org.apache.commons.lang3.builder.Builder;

import com.vaadin.flow.component.icon.VaadinIcon;

import de.admera.ui.hybridmenu.data.MenuConfig;
import de.admera.ui.hybridmenu.data.enums.NotificationPosition;

public class MenuConfigBuilder implements Builder<MenuConfig> {
	
	private VaadinIcon subMenuIcon = VaadinIcon.ANGLE_UP;
	private VaadinIcon notificationButtonIcon = VaadinIcon.BELL;
	private VaadinIcon notificationButtonEmptyIcon = VaadinIcon.BELL_O;
	private VaadinIcon notificationCenterCloseIcon = VaadinIcon.ANGLE_RIGHT;
	private VaadinIcon notificationRemoveIcon = VaadinIcon.CLOSE;
	private NotificationPosition notificationPosition = NotificationPosition.BOTTOM;
	private long notificationDisplayTime = 5000;
	private VaadinIcon breadcrumbSeperatorIcon = VaadinIcon.ANGLE_RIGHT;
	private boolean breadcrumbs = true;
	
	
	public MenuConfigBuilder() {}
	
	public  MenuConfigBuilder(MenuConfig config) {
		
		this.subMenuIcon = config.getSubMenuIcon();
		this.notificationButtonIcon = config.getNotificationButtonIcon();
		this.notificationButtonEmptyIcon = config.getNotificationButtonEmptyIcon();
		this.notificationCenterCloseIcon = config.getNotificationCenterCloseIcon();
		this.notificationRemoveIcon = config.getNotificationRemoveIcon();
		this.notificationPosition = config.getNotificationPosition();		
		this.notificationDisplayTime = config.getNotificationDisplayTime();
		this.breadcrumbSeperatorIcon = config.getBreadcrumbSeperatorIcon();
		this.breadcrumbs = config.getBreadcrumbs();
	}
	
	public MenuConfigBuilder subMenuIcon(final VaadinIcon vaadinIcon) {	
		this.subMenuIcon = vaadinIcon;
		return this;
	}
	
	public MenuConfigBuilder notificationButtonIcon(final VaadinIcon vaadinIcon) {	
		this.notificationButtonIcon = vaadinIcon;
		return this;
	}
	
	public MenuConfigBuilder notificationButtonEmptyIcon(final VaadinIcon vaadinIcon) {	
		this.notificationButtonEmptyIcon = vaadinIcon;
		return this;
	}
	
	public MenuConfigBuilder notificationCenterCloseIcon(final VaadinIcon vaadinIcon) {	
		this.notificationCenterCloseIcon = vaadinIcon;
		return this;
	}
	
	public MenuConfigBuilder notificationRemoveIcon(final VaadinIcon vaadinIcon) {	
		this.notificationRemoveIcon = vaadinIcon;
		return this;
	}
	
	public MenuConfigBuilder notificationPosition(final NotificationPosition notificationPosition) {	
		this.notificationPosition = notificationPosition;
		return this;
	}
	
	public MenuConfigBuilder notificationDisplayTime(final long time) {	
		this.notificationDisplayTime = time;
		return this;
	}
	
	public MenuConfigBuilder breadcrumbSeperatorIcon(final VaadinIcon vaadinIcon) {	
		this.breadcrumbSeperatorIcon = vaadinIcon;
		return this;
	}
	
	public MenuConfigBuilder breadcrumbs(final boolean breadcrumbs) {	
		this.breadcrumbs = breadcrumbs;
		return this;
	}
	
	@Override
	public MenuConfig build() {
		
		MenuConfig config = new MenuConfig();
		
		config.setSubMenuIcon(subMenuIcon);
		config.setNotificationButtonIcon(notificationButtonIcon);
		config.setNotificationButtonEmptyIcon(notificationButtonEmptyIcon);
		config.setNotificationCenterCloseIcon(notificationCenterCloseIcon);
		config.setNotificationRemoveIcon(notificationRemoveIcon);
		config.setNotificationPosition(notificationPosition);
		config.setNotificationDisplayTime(notificationDisplayTime);
		config.setBreadcrumbSeperatorIcon(breadcrumbSeperatorIcon);
		config.setBreadcrumbs(breadcrumbs);
		
		return config;
	}

}
