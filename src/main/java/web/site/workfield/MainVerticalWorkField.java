package web.site.workfield;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class MainVerticalWorkField extends VerticalLayout {

    private Layout horrizontalField = new WorkingField();


    public MainVerticalWorkField() {

        Label label = new Label("Home   Dashboard");

        label.setStyleName(ValoTheme.MENU_TITLE);

        this.addComponents(label, horrizontalField);

        //   labelLayout.setComponentAlignment(label, Alignment.TOP_LEFT);
        //  labelLayout.setComponentAlignment(label, Alignment.MIDDLE_LEFT);
        //  labelLayout.setComponentAlignment(label, Alignment.BOTTOM_LEFT);

        this.setSpacing(false);
        this.setMargin(false);
        this.setSizeFull();

    }

}
