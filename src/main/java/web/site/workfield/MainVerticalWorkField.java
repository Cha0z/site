package web.site.workfield;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class MainVerticalWorkField extends VerticalLayout {

    private Layout horrizontalField = new WorkingField();


    public MainVerticalWorkField(){

        Label label = new Label("Home   Dashboard");
        HorizontalLayout labelLayout = new HorizontalLayout();
        labelLayout.setWidth("100%");

        labelLayout.addComponent(label);
        label.setStyleName(ValoTheme.MENU_TITLE);

        this.addComponents(labelLayout,horrizontalField);

//        labelLayout.setComponentAlignment(label, Alignment.TOP_LEFT);

        this.setSpacing(false);
        this.setMargin(false);
        this.setSizeFull();

    }

}
