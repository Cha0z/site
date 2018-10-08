package web.site.menu.right;

import com.vaadin.ui.Accordion;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class RightMenu extends VerticalLayout {

    private UserForm userForm = new UserForm();

    public RightMenu() {

        VerticalLayout headOfMenu = new VerticalLayout();

        this.addComponent(headOfMenu);
        headOfMenu.setMargin(false);
        headOfMenu.setSpacing(false);
        Label firstLine = new Label("Quick Actions");
        Label secondLine = new Label("Add new users and notifications");

        firstLine.setStyleName(ValoTheme.LABEL_COLORED);
        firstLine.setStyleName(ValoTheme.LABEL_LARGE);
        secondLine.setStyleName(ValoTheme.LABEL_LIGHT);
        secondLine.setStyleName(ValoTheme.LABEL_SMALL);

        headOfMenu.addComponents(firstLine, secondLine);
        headOfMenu.setMargin(false);
        headOfMenu.setStyleName(ValoTheme.MENU_TITLE);

        Accordion accordion = new Accordion();
        accordion.addTab(userForm, "Add Basic User");
        accordion.addTab(new Label("Some content here"), "Add Advanced User");
        accordion.addTab(new Label("Some content here"), "Add Notifications");

        this.addComponent(accordion);

        this.setMargin(false);
        this.setSpacing(false);

        this.setStyleName(ValoTheme.LAYOUT_WELL);


    }
}
