package de.admera.ui.hybridmenu.data;

import com.vaadin.flow.component.icon.VaadinIcon;

import de.admera.ui.hybridmenu.data.builder.MenuConfigBuilder;
import de.admera.ui.hybridmenu.data.enums.NotificationPosition;

public class MenuConfig {

	private VaadinIcon subMenuIcon = VaadinIcon.ANGLE_UP;
	private VaadinIcon notificationButtonIcon = VaadinIcon.BELL;
	private VaadinIcon notificationButtonEmptyIcon = VaadinIcon.BELL_O;
	private VaadinIcon notificationCenterCloseIcon = VaadinIcon.ANGLE_RIGHT;
	private VaadinIcon notificationRemoveIcon = VaadinIcon.CLOSE;
	private NotificationPosition notificationPosition = NotificationPosition.BOTTOM;
	private long notificationDisplayTime = 5000;
	private VaadinIcon breadcrumbSeperatorIcon = VaadinIcon.ANGLE_RIGHT;
	private boolean breadcrumbs = true;
	
	public static int notificationQueueMax = 200;
	
	
	
	public static MenuConfigBuilder builder() {
		
		return new MenuConfigBuilder();
	}
	
	public void setSubMenuIcon(final  VaadinIcon vaadinIcon) {
		this.subMenuIcon = vaadinIcon;
	}
	
	public VaadinIcon getSubMenuIcon() {
		
		 VaadinIcon tmp = this.subMenuIcon;
		
		return tmp;
	}
	
	public void setNotificationButtonIcon(final  VaadinIcon vaadinIcon) {
		this.notificationButtonIcon = vaadinIcon;
	}
	
	public VaadinIcon getNotificationButtonIcon() {
		return this.notificationButtonIcon;
	}
	
	public void setNotificationButtonEmptyIcon(final  VaadinIcon vaadinIcon) {
		this.notificationButtonEmptyIcon = vaadinIcon;
	}
	
	public VaadinIcon getNotificationButtonEmptyIcon() {
		return this.notificationButtonEmptyIcon;
	}
	
	public void setNotificationCenterCloseIcon(final  VaadinIcon vaadinIcon) {
		this.notificationCenterCloseIcon = vaadinIcon;
	}
	
	public VaadinIcon getNotificationCenterCloseIcon() {
		return this.notificationCenterCloseIcon;
	}
	
	public void setNotificationRemoveIcon(final  VaadinIcon vaadinIcon) {
		this.notificationRemoveIcon = vaadinIcon;
	}
	
	public VaadinIcon getNotificationRemoveIcon() {
		return this.notificationRemoveIcon;
	}
	
	public void setBreadcrumbSeperatorIcon(final  VaadinIcon vaadinIcon) {
		this.breadcrumbSeperatorIcon = vaadinIcon;
	}
	
	public VaadinIcon getBreadcrumbSeperatorIcon() {
		return this.breadcrumbSeperatorIcon;
	}
	
	public void setNotificationPosition(final  NotificationPosition notificationPosition) {
		this.notificationPosition = notificationPosition;
	}
	
	public NotificationPosition getNotificationPosition() {
		return this.notificationPosition;
	}
	
	
	public void setNotificationDisplayTime(final  long time) {
		this.notificationDisplayTime = time;
	}
	
	public long getNotificationDisplayTime() {
		return this.notificationDisplayTime;
	}

	public void setBreadcrumbs(final  boolean breadcrumbs) {
		this.breadcrumbs = breadcrumbs;
	}
	
	public boolean getBreadcrumbs() {
		return this.breadcrumbs;
	}
	
	public boolean isBreadcrumbs() {
		return this.breadcrumbs;
	}
	

}