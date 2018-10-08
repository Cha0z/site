package web.site;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import web.site.header.HeaderUI;
import web.site.menu.left.Menu;
import web.site.workfield.MainVerticalWorkField;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */

@Theme("mytheme")
public class MyUI extends UI {

    private Layout head = new HeaderUI();
    private Layout menu = new Menu();
    private HorizontalLayout fieldWithMenuAndWorkField = new HorizontalLayout();
    private VerticalLayout fieldWithWorkField = new MainVerticalWorkField();


    public MyUI() {
        fieldWithMenuAndWorkField.setSizeFull();
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(false);

        layout.setMargin(false);
        setContent(layout);

        layout.addComponent(head);


        layout.addComponent(fieldWithMenuAndWorkField);

        fieldWithMenuAndWorkField.addComponents(menu, fieldWithWorkField);
        fieldWithMenuAndWorkField.setSpacing(false);
        fieldWithMenuAndWorkField.setMargin(false);

        fieldWithMenuAndWorkField.setExpandRatio(fieldWithWorkField, 1);
    /*    this.setStyleName(ValoTheme.UI_WITH_MENU);*/

    }


    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
