package web.site.workfield;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import web.site.menu.right.RightMenu;
import web.site.workfield.leftverticalfield.ActiveSessionsField;
import web.site.workfield.leftverticalfield.ActivityField;

public class WorkingField extends HorizontalLayout {


    private ActivityField activityField = new ActivityField();
    private ActiveSessionsField activeSessionsField = new ActiveSessionsField();
    private RightMenu rightMenu = new RightMenu();

    public WorkingField() {

        VerticalLayout leftContainer = new VerticalLayout();
        VerticalLayout rightContainer = new VerticalLayout();

      //  leftContainer.setWidth("60em");


        this.addComponents(leftContainer, rightContainer);
        leftContainer.addComponents(activityField, activeSessionsField);
        rightContainer.addComponent(rightMenu);

        this.setExpandRatio(leftContainer, 0.82f);
        this.setExpandRatio(rightContainer,0.18f);


        leftContainer.setMargin(false);
        rightContainer.setSpacing(false);
        rightContainer.setMargin(false);

        this.setSpacing(false);
        setWidth("100%");


    }


}
