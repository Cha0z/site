package web.site.menu.left;

import com.vaadin.ui.Accordion;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


public class AccordionElementMenu extends Accordion {
    private static volatile AccordionElementMenu instance;


    public AccordionElementMenu() {


        this.setStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        this.setWidth("17em");


        Layout tab1 = new VerticalLayout();
        tab1.addComponents(new Label("DashBoard"),
                new Label("Configure"),
                new Label("Settings and Options"),
                new Label("Administration Privileges"),
                new Label("Users and Groups"),
                new Label("ActivityField")
        );

        this.addTab(tab1, "Home");

        Layout tab2 = new VerticalLayout();
        tab2.addComponent(new Label("Component"));
        this.addTab(tab2, "Overview");

        Layout tab3 = new VerticalLayout();
        tab3.addComponent(new Label("Component"));
        this.addTab(tab3, "Settings");

        Layout tab4 = new VerticalLayout();
        tab4.addComponent(new Label("Component"));
        this.addTab(tab4, "Users and Groups");
    }


    public static AccordionElementMenu getInstance() {
        AccordionElementMenu localInstance = instance;
        if (localInstance == null) {
            synchronized (AccordionElementMenu.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new AccordionElementMenu();
                }
            }
        }
        return localInstance;
    }


}
