package web.site.menu.left;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Menu extends VerticalLayout {

    private AccordionElementMenu accordionElementMenu = AccordionElementMenu.getInstance();

    public Menu() {


        configMenu();

        Label title = new Label("Main");
        title.addStyleName(ValoTheme.MENU_TITLE);


        Label productInformation = new Label("Product Information");
        productInformation.addStyleName(ValoTheme.MENU_TITLE);
        VerticalLayout panel = new VerticalLayout();


        this.addComponent(title);
        this.addComponents(accordionElementMenu);
        this.addComponent(productInformation);
        this.addComponent(panel);


        configPanel(panel);


        TextArea area = new TextArea();

        area.setValue("Contact support\n" +
                "\n" +
                "Account #\n" +
                "Opened \n" +
                "Yet another row");


        panel.addComponent(area);
        panel.setComponentAlignment(area, Alignment.MIDDLE_CENTER);


    }

    private void configPanel(VerticalLayout panel) {
        // panel.setStyleName(ValoTheme.MENU_PART);
        panel.setWidth("100%");

        /* panel.setStyleName(ValoTheme.PANEL_BORDERLESS);*/
        panel.addStyleName(ValoTheme.LAYOUT_WELL);
    }

    private void configMenu() {
        this.setWidth("17em");
        this.setHeight(100, Sizeable.UNITS_PERCENTAGE);
        this.setId("Navigation_bar");
        this.setSpacing(false);
        this.setMargin(false);
        this.addStyleName(ValoTheme.MENU_PART);
    }
}
