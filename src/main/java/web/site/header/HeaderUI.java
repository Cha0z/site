package web.site.header;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class HeaderUI extends HorizontalLayout {

    public HeaderUI() {


        this.addStyleName(ValoTheme.LAYOUT_WELL);
        this.setSizeFull();

        this.setWidth("100%");
        this.setSpacing(true);


        Image logo = new Image(null, new ClassResource("/logo.png"));
        this.addComponent(logo);

        logo.setHeight("2em");


        Label text = new Label("MyDashBoard");
        Label text2 = new Label("Management Console");

        configureTextInHeader(text, text2);


        VerticalLayout textLayout = new VerticalLayout(text, text2);
        textLayout.setComponentAlignment(text, Alignment.MIDDLE_LEFT);
        textLayout.setComponentAlignment(text2, Alignment.MIDDLE_LEFT);

        configTextLayout(textLayout);

        this.addComponent(textLayout);


        HorizontalLayout buttons = new HorizontalLayout();


        Button language = new Button("Language", VaadinIcons.GLOBE);
        Button help = new Button("Help", VaadinIcons.LIFEBUOY);
        Button user = new Button("Hi,Admin", VaadinIcons.USER);
        buttons.setId("buttons");

        confButtons(buttons, language, help, user);

        buttons.addComponents(language, help, user);


        this.addComponents(buttons);


        this.setExpandRatio(logo, 0);
        this.setExpandRatio(textLayout, 1);
        this.setExpandRatio(buttons, 1);

        this.setComponentAlignment(logo, Alignment.MIDDLE_RIGHT);
        this.setComponentAlignment(buttons, Alignment.MIDDLE_RIGHT);


    }

    private void confButtons(HorizontalLayout buttons, Button language, Button help, Button user) {

        language.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        help.setStyleName(ValoTheme.BUTTON_BORDERLESS);
        user.setStyleName(ValoTheme.BUTTON_BORDERLESS);
    }

    private void configTextLayout(VerticalLayout textLayout) {
        textLayout.setMargin(false);
        textLayout.setSpacing(false);
        textLayout.setMargin(false);

    }

    private void configureTextInHeader(Label text, Label text2) {
        text.setStyleName(ValoTheme.LABEL_BOLD);

        text.setStyleName(ValoTheme.LABEL_H4);
        text.setStyleName(ValoTheme.LABEL_NO_MARGIN);

        text2.setStyleName(ValoTheme.LABEL_LIGHT);
        text2.setStyleName(ValoTheme.LABEL_TINY);
        text2.setStyleName(ValoTheme.LABEL_NO_MARGIN);
    }


}
