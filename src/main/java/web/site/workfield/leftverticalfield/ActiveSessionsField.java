package web.site.workfield.leftverticalfield;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import web.site.user.User;
import web.site.user.UserService;

import java.util.List;

public class ActiveSessionsField extends VerticalLayout {

    private TextField searchUser = new TextField();
    private Grid<User> grid = new Grid<>(User.class);
    private UserService service = UserService.getInstance();


    public ActiveSessionsField() {
        this.setMargin(new MarginInfo(false,true,false,true));

        HorizontalLayout fieldWithTextAndSearch = new HorizontalLayout();

      //  fieldWithTextAndSearch.setMargin(new MarginInfo(false,true,false,true));

        VerticalLayout activeSessionsText = new VerticalLayout();
        activeSessionsText.setMargin(false);
        activeSessionsText.setSpacing(false);

        Label firstLine = new Label("Active Sessions");
        firstLine.setStyleName(ValoTheme.LABEL_NO_MARGIN);

        Label secondLine = new Label("monitor the most recent user activity");
        secondLine.setStyleName(ValoTheme.LABEL_NO_MARGIN);

        activeSessionsText.addComponents(firstLine, secondLine);
        configActiveSessionsText(firstLine, secondLine);

        searchUser.setPlaceholder("Search User ID");
        searchUser.addValueChangeListener(e -> updateList());
        searchUser.setValueChangeMode(ValueChangeMode.LAZY);

        grid.setColumns("id", "name", "surname", "lastSession", "status", "activity");
        grid.setSizeFull();



        fieldWithTextAndSearch.addComponents(activeSessionsText, searchUser);
        this.addComponents(fieldWithTextAndSearch, grid);

        this.setExpandRatio(grid, 1);

        fieldWithTextAndSearch.setComponentAlignment(searchUser,Alignment.MIDDLE_RIGHT);

        fieldWithTextAndSearch.setWidth("100%");

        updateList();




    }

    private void configActiveSessionsText(Label firstLine, Label secondLine) {
        firstLine.setStyleName(ValoTheme.LABEL_COLORED);
        firstLine.setStyleName(ValoTheme.LABEL_LARGE);
        secondLine.setStyleName(ValoTheme.LABEL_LIGHT);
        secondLine.setStyleName(ValoTheme.LABEL_SMALL);
    }

    public void updateList() {
        List<User> users = service.findAll(searchUser.getValue());
        grid.setItems(users);

    }
}
